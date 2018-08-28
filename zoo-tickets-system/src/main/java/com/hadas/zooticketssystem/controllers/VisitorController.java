package com.hadas.zooticketssystem.controllers;

import com.hadas.zooticketssystem.services.VisitorServiceImp;
import com.hadas.zooticketssystem.ticket.Ticket;
import com.hadas.zooticketssystem.visitors.Senior;
import com.hadas.zooticketssystem.visitors.Solider;
import com.hadas.zooticketssystem.visitors.Student;
import com.hadas.zooticketssystem.visitors.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VisitorController {
    @Autowired
    private VisitorServiceImp visitorService;

    @PostMapping("/entrance/visitor")
    public Optional<Ticket> save(@RequestBody Visitor visitor){
        return this.visitorService.save(visitor);
    }

    @PostMapping("/entrance/student")
    public Optional<Ticket> save(@RequestBody Student student){
        return this.visitorService.save(student);
    }

    @PostMapping("/entrance/solider")
    public Optional<Ticket> save(@RequestBody Solider solider){
        return this.visitorService.save(solider);
    }

    @PostMapping("/entrance/senior")
    public Optional<Ticket> save(@RequestBody Senior senior){ return this.visitorService.save(senior); }

    @DeleteMapping("/exit/{id}")
    public void save(@PathVariable Long id){ this.visitorService.delete(id); }

}
