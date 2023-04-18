package com.example.csapi.web_service.impl;

import com.example.csapi.exceptions.NoSuchDriverException;
import com.example.csapi.model.Bid;
import com.example.csapi.model.Location;
import com.example.csapi.model.documets.Coi;
import com.example.csapi.model.validations.Driver;
import com.example.csapi.repository.DriverRepository;
import com.example.csapi.web_service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver editDriver(String id, Driver driver) {
        return null;
    }

    @Override
    public void deleteDriver(String id) {
        driverRepository.deleteById(id);
    }

    @Override
    public void putBidForLoad(String id, Bid bid) {

    }

    @Override
    public void cancelBidForLoad(String driverId, String bidId) {

    }

    @Override
    public Coi updateCOI(String driverId, Coi coi) {
        return null;
    }

    @Override
    public Driver changeCurrentLocation(String id, Location currentLocation) {
        return null;
    }

    @Override
    public Driver findDriverById(String id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()) {
            return optionalDriver.get();
        } else {
            throw new NoSuchDriverException("No driver with unit: " + id + " was found");
        }
    }


    //Should have tough realization
    @Override
    public List<Driver> findDriverByLocation(Location currentLocation) {
        return null;
    }

    @Override
    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }
}
