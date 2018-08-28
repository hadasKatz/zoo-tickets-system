package com.hadas.zooticketssystem.businessLogic;

import com.hadas.zooticketssystem.services.TicketServiceImp;
import com.hadas.zooticketssystem.ticket.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Cashier {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TicketServiceImp ticketService;


    @JmsListener(destination = "mainQueue", containerFactory = "myFactory")
    @Async
    public void createTicket(Request request) throws InterruptedException {
        logger.info("Cashier: Thread " + Thread.currentThread().getName() + " got a request: " + request.getTimeStamp() +
                ", " +  ", " + request.getId() + ", " + request.getDiscount());

        int discount =  request.getDiscount();
        int price = 0;

        if(discount != (-1)){
            price = 100 - discount;
        }

        logger.info("Cashier: Thread " + Thread.currentThread().getName() + " is going to sleep");
        Thread.sleep(10000);
        logger.info("Cashier: Thread " + Thread.currentThread().getName() + " is awake, sending a new ticket to the repository");
        this.ticketService.save(new Ticket(request.getId(), request.getTimeStamp(), price));
    }

}
