package com.example.csapi.web_service;

import com.example.csapi.model.validations.Broker;

import java.util.List;

public interface BrokerService {
    Broker createBroker(Broker broker);
    Broker updateBroker(String id, Broker broker);
    void deleteBroker(String id);
    Broker findBroker(String id);
    Broker findBrokerByMC(String mcNumber);
    List<Broker> findBrokerByCompanyName(String brokerName);
    List<Broker> findAllBrokers();
}
