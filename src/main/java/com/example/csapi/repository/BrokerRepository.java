package com.example.csapi.repository;

import com.example.csapi.model.validations.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Short> {
    List<Broker> findBrokerByBrokerName(String brokerName);
    Optional<Broker> findBrokerByBrokerMcNumber(String mcNumber);
}
