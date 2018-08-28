package com.hadas.zooticketssystem.businessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Data {
    private boolean transfer = true;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    synchronized void send() {
        logger.info("Data send: Thread " + Thread.currentThread().getName() + " is in send");
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
            }
        }
        transfer = false;
        notify();
    }

    public synchronized void receive() {
        logger.info("Data receive: Thread " + Thread.currentThread().getName() + " is going to sleep");
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
            }
        }
        transfer = true;
        notify();
    }

}
