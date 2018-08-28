package com.hadas.zooticketssystem.ticket;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
public class Ticket {
    @Id
    private Long id;
    private String entranceTime;
    private int price;


    public Ticket(Long id, String entranceTime, int price) {
        this.id = id;
        this.entranceTime = entranceTime;
        this.price = price;
    }

    public Ticket() {
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
