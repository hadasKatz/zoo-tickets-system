package com.hadas.zooticketssystem.repositories;

import com.hadas.zooticketssystem.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{
//public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
