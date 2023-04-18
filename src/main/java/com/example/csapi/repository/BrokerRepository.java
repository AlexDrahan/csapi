package com.example.csapi.repository;

import com.example.csapi.model.validations.Broker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrokerRepository extends MongoRepository<Broker, String> {
    List<Broker> findBrokerByBrokerName(String brokerName);
    Optional<Broker> findBrokerByBrokerMcNumber(String mcNumber);
}
