package com.example.csapi.web_service.impl;

import com.example.csapi.exceptions.NoSuchBrokerException;
import com.example.csapi.model.validations.Broker;
import com.example.csapi.repository.BrokerRepository;
import com.example.csapi.web_service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrokerServiceImpl implements BrokerService {
    @Autowired
    BrokerRepository brokerRepository;

    @Override
    public Broker createBroker(Broker broker) {
        return brokerRepository.save(broker);
    }

    @Override
    public Broker updateBroker(Short id, Broker broker) {
        Broker brokerToUpdate = findBrokerOptional(id);
        brokerToUpdate.setBrokerName(broker.getBrokerName());
        brokerToUpdate.setCompanyName(broker.getCompanyName());
        brokerToUpdate.setAllianceMemberSince(broker.getAllianceMemberSince());
        brokerToUpdate.setPostedBy(brokerToUpdate.getPostedBy());
        brokerToUpdate.setEmail(brokerToUpdate.getEmail());
        brokerToUpdate.setPhone(brokerToUpdate.getPhone());
        brokerToUpdate.setFax(brokerToUpdate.getFax());
        brokerToUpdate.setAuthority(brokerToUpdate.getAuthority());
        brokerToUpdate.setMcNumber2(brokerToUpdate.getMcNumber2());
        brokerToUpdate.setCvorNumber(brokerToUpdate.getCvorNumber());
        brokerToUpdate.setCargoInsurance(brokerToUpdate.getCargoInsurance());
        brokerToUpdate.setWorkDocuments(brokerToUpdate.getWorkDocuments());
        return  brokerToUpdate;
    }

    @Override
    public void deleteBroker(Short id) {
        brokerRepository.delete(findBrokerOptional(id));
    }

    @Override
    public Broker findBroker(Short id) {
        return findBrokerOptional(id);
    }

    @Override
    public Broker findBrokerByMC(String mcNumber) {
        Optional<Broker> optionalBroker = brokerRepository.findBrokerByBrokerMcNumber(mcNumber);
        if (optionalBroker.isPresent()) {
            return optionalBroker.get();
        } else {
            throw new NoSuchBrokerException("No such broker exception");
        }
    }

    @Override
    public List<Broker> findBrokerByCompanyName(String brokerName) {
        if (brokerRepository.findBrokerByBrokerName(brokerName) != null) {
            return brokerRepository.findBrokerByBrokerName(brokerName);
        } else {
            throw new NoSuchBrokerException("No such broker exception");
        }
    }

    @Override
    public List<Broker> findAllBrokers() {
        if (!brokerRepository.findAll().isEmpty()) {
            return brokerRepository.findAll();
        } else {
            throw new NoSuchBrokerException("No such brokers have benn registered");
        }
    }

    private Broker findBrokerOptional(Short id) {
        Optional<Broker> optionalBroker = brokerRepository.findById(id);
        if (optionalBroker.isPresent()) {
            return optionalBroker.get();
        } else {
            throw new NoSuchBrokerException("No such broker exception");
        }
    }
}
