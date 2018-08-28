package com.hadas.zooticketssystem.businessLogic;

import org.springframework.stereotype.Component;

@Component
public class Request {
    private String timeStamp;
    private Long id;
    private int discount;

    public Request(String timeStamp, Long id, int discount) {
        this.timeStamp = timeStamp;
        this.id = id;
        this.discount = discount;
    }

    public Request() {
    }


    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Long getId() {
        return id;
    }

    public int getDiscount() {
        return discount;
    }


}
