package com.hadas.zooticketssystem.services;

import com.hadas.zooticketssystem.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Optional<Ticket> getById(Long id);
    void save(Ticket ticket);
    List<Ticket> findAll();
    boolean isExist(Long id);
}
