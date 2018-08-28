package com.hadas.zooticketssystem.controllers;

import com.hadas.zooticketssystem.services.StatusServiceImp;
import com.hadas.zooticketssystem.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @Autowired
    private StatusServiceImp statusService;

    @GetMapping("/status")
    public Status getStatus() {
        return this.statusService.getStatus();
    }

}
