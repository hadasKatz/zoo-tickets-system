package com.hadas.zooticketssystem.services;

import com.hadas.zooticketssystem.businessLogic.Request;
import com.hadas.zooticketssystem.repositories.VisitorRepository;
import com.hadas.zooticketssystem.ticket.Ticket;
import com.hadas.zooticketssystem.visitors.Senior;
import com.hadas.zooticketssystem.visitors.Solider;
import com.hadas.zooticketssystem.visitors.Student;
import com.hadas.zooticketssystem.visitors.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class VisitorServiceImp implements VisitorService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private VisitorRepository repository;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private TicketServiceImp ticketService;
    @Resource
    private RedisTemplate<String, Ticket> redisTemplate;


    @Override
    public Optional<Ticket> save(Visitor entrance) {
        logger.info("Visitor Service: saving VISITOR in Redis");
        Visitor visitor = getTicket(entrance, 0);
        return waitForTicket(visitor.getId());
    }

    @Override
    public Optional<Ticket> save(Student entrance) {
        logger.info("Visitor Service: saving STUDENT in Redis");
        Visitor visitor = getTicket(entrance, 10);
        return waitForTicket(visitor.getId());
    }

    @Override
    public Optional<Ticket> save(Solider entrance) {
        logger.info("Visitor Service: saving SOLIDER in Redis");
        Visitor visitor = getTicket(entrance, 20);
        return waitForTicket(visitor.getId());
    }

    @Override
    public Optional<Ticket> save(Senior entrance) {
        logger.info("Visitor Service: saving SENIOR in Redis");
        Visitor visitor = getTicket(entrance, 0);
        return waitForTicket(visitor.getId());
    }



    @Override
    public Visitor getTicket(Visitor entrance, int discount) {
        entrance.setStatus(true);
        Visitor newVisitor;
        if(isExist(entrance.getId())){
            logger.info("Visitor Service: visitor already exists");
            Long currentId = entrance.getId();
            entrance.setId(currentId + 1);
            newVisitor = this.repository.save(entrance);
            sendRequest(entrance.getTimeStamp(), entrance.getId(), (-1));
        }
        else{
            newVisitor = this.repository.save(entrance);
            setExpire("Visitor:" + entrance.getId());
            if(newVisitor instanceof Senior){
                logger.info("Visitor Service: visitor is senior");
                sendRequest(newVisitor.getTimeStamp(), newVisitor.getId(), ((Senior) newVisitor).getAge());
            }
            else{
                sendRequest(newVisitor.getTimeStamp(), newVisitor.getId(), discount);
            }
        }
        return newVisitor;
    }


    @Override
    public void sendRequest(String entranceTime, Long id, int discount) {
        Request request = new Request(entranceTime, id, discount);
        this.jmsTemplate.convertAndSend("mainQueue", request);
        logger.info("Visitor Service: Thread " + Thread.currentThread().getName() + " sent a request: " + request.getTimeStamp() +
                 ", " + request.getId() + ", " + request.getDiscount());
    }


    @Override
    public List<Visitor> findAll() {
        return (List<Visitor>) this.repository.findAll();
    }


    @Override
    public void delete(Long id) {
        Optional<Visitor> visitor = this.repository.findById(id);
        visitor.ifPresent(visitor1 -> visitor1.setStatus(false));
        this.repository.deleteById(id);
        visitor.ifPresent(visitor1 -> this.repository.save(visitor1));
    }

    @Override
    public boolean isExist(Long id) {
        return this.repository.existsById(id);
    }

    private void setExpire(final String key) {
        Set<byte[]> keys = redisTemplate.getConnectionFactory().getConnection().keys(key.getBytes());
        for (byte[] tempKey : keys) {
            redisTemplate.getConnectionFactory().getConnection().expire(tempKey, 86400);
        }
    }

    private synchronized Optional<Ticket> waitForTicket(Long id) {
        logger.info("Visitor Service: " + Thread.currentThread().getName() + " is now waiting for a Ticket");
        boolean found = false;
        while (!found){
            if(ticketService.isExist(id)){
                found = true;
            }
        }
        return ticketService.getById(id);
    }
}
