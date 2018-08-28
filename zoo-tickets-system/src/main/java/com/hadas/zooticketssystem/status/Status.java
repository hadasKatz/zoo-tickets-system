package com.hadas.zooticketssystem.status;

import org.springframework.stereotype.Component;

@Component
public class Status {
    private int ticketsSales;
    private int numOfVisitors;

    public Status(int ticketsSales, int numOfVisitors) {
        this.ticketsSales = ticketsSales;
        this.numOfVisitors = numOfVisitors;
    }

    public Status() {
    }

    public int getTicketsSales() {
        return ticketsSales;
    }

    public int getNumOfVisitors() {
        return numOfVisitors;
    }

    public void setTicketsSales(int ticketsSales) {
        this.ticketsSales = ticketsSales;
    }

    public void setNumOfVisitors(int numOfVisitors) {
        this.numOfVisitors = numOfVisitors;
    }
}
