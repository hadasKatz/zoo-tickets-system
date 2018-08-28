package com.hadas.zooticketssystem.services;

import com.hadas.zooticketssystem.repositories.TicketRepository;
import com.hadas.zooticketssystem.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService{
    @Autowired
    private TicketRepository repository;


    @Override
    public Optional<Ticket> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void save(Ticket ticket) {
        this.repository.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) this.repository.findAll();
    }

    @Override
    public boolean isExist(Long id) {
        return this.repository.existsById(id);
    }


}
