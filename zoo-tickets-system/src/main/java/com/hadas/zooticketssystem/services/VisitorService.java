package com.hadas.zooticketssystem.services;

import com.hadas.zooticketssystem.businessLogic.Request;
import com.hadas.zooticketssystem.ticket.Ticket;
import com.hadas.zooticketssystem.visitors.Senior;
import com.hadas.zooticketssystem.visitors.Solider;
import com.hadas.zooticketssystem.visitors.Student;
import com.hadas.zooticketssystem.visitors.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {
    Optional<Ticket> save(Visitor entrance);
    Optional<Ticket> save(Student entrance);
    Optional<Ticket> save(Solider entrance);
    Optional<Ticket> save(Senior entrance);
    Visitor getTicket(Visitor entrance, int discount);
    void sendRequest(String entranceTime, Long id, int discount);
    void delete(Long id);
    boolean isExist(Long id);
    List<Visitor> findAll();

}
