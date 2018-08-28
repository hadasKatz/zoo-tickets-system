package com.hadas.zooticketssystem.services;

import com.hadas.zooticketssystem.status.Status;
import com.hadas.zooticketssystem.ticket.Ticket;
import com.hadas.zooticketssystem.visitors.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImp implements StatusService{
    @Autowired
    private Status status;
    @Autowired
    private TicketServiceImp ticketService;
    @Autowired
    private VisitorServiceImp visitorService;

    @Override
    public Status getStatus() {
        calcSales();
        calcVisitorsNum();
        return status;
    }

    @Override
    public void calcVisitorsNum() {
        List<Visitor> visitorsList = this.visitorService.findAll();
        int num = 0;
        for (Visitor visitor : visitorsList) {
            if(visitor.getStatus()){
                num++;
            }
        }
        this.status.setNumOfVisitors(num);
    }

    @Override
    public void calcSales() {
        List<Ticket> ticketList = this.ticketService.findAll();
        int sum = 0;
        for (Ticket ticket : ticketList) {
            sum = sum + ticket.getPrice();
        }
        this.status.setTicketsSales(sum);
    }
}
