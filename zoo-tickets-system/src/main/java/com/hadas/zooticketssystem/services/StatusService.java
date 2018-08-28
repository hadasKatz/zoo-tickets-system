package com.hadas.zooticketssystem.services;

import com.hadas.zooticketssystem.status.Status;

public interface StatusService {
    Status getStatus();
    void calcVisitorsNum();
    void calcSales();
}


