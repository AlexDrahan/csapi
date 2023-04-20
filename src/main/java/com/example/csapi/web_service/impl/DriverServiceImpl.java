package com.example.csapi.web_service.impl;

import com.example.csapi.coreAlgorithmsService.CarSuitabilityService;
import com.example.csapi.exceptions.NoSuchDriverException;
import com.example.csapi.model.Bid;
import com.example.csapi.model.CarData;
import com.example.csapi.model.Location;
import com.example.csapi.model.documets.Coi;
import com.example.csapi.model.validations.Driver;
import com.example.csapi.model.validations.LoadInformation;
import com.example.csapi.repository.DriverRepository;
import com.example.csapi.web_service.BidService;
import com.example.csapi.web_service.DriverService;
import com.example.csapi.web_service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private LoadService loadService;
    @Autowired
    CarSuitabilityService carSuitabilityService;
    @Autowired
    BidService bidService;

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver editDriver(String id, Driver driver) {
        Driver currentDriverToUpdate = findDriverById(id);
        currentDriverToUpdate.setDriverFirstName(driver.getDriverFirstName());
        currentDriverToUpdate.setDriverLastName(driver.getDriverLastName());
        currentDriverToUpdate.setDriverPhoneNumber(driver.getDriverPhoneNumber());
        currentDriverToUpdate.setDriverEmail(driver.getDriverEmail());
        //COI should be updated in its own service but reference should be here
        currentDriverToUpdate.setHomeLocation(driver.getHomeLocation());
        currentDriverToUpdate.setCurrentLocation(driver.getCurrentLocation());
        currentDriverToUpdate.setTeam(driver.isTeam());
        currentDriverToUpdate.setTracked(driver.isTracked());
        currentDriverToUpdate.setCanadaFreights(driver.isCanadaFreights());
        currentDriverToUpdate.setWorkDocuments(driver.getWorkDocuments());
        currentDriverToUpdate.setDetails(driver.getDetails());
        return currentDriverToUpdate;
    }

    @Override
    public void deleteDriver(String id) {
        driverRepository.deleteById(id);
    }

    @Override
    public Bid putBidForLoad(String loadId, String driverId, Bid bidToPut) {
        LoadInformation updatedLoad = loadService.putABid(loadId, driverId, bidToPut);
        Bid justPostedBid = bidService.findById(bidToPut.getId());
        // Loop through the bids in the updatedLoad object to find the justPostedBid
        for (Bid bid: updatedLoad.getCurrentBids()) {
            if (Objects.equals(bid.getId(), justPostedBid.getId())) {
                return justPostedBid;
            }
        }
        // If the justPostedBid is not found, throw a runtime exception
        throw new RuntimeException("Something went wrong with put a bid method");
    }

    @Override
    public void cancelBidForLoad(String driverId, String bidId) {
        Bid expectedBid = bidService.findById(bidId);
        if (Objects.equals(expectedBid.getDriverId(), driverId)) {
            bidService.deleteBid(bidId);
        } else {
            throw new RuntimeException("User doesn't have permissions to cancel this bid");
        }
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


    //temp. It should find loads due to driver location
    @Override
    public List<LoadInformation> findAvailableLoads(Driver driver) {
        List<LoadInformation> availableLoads = loadService.findAllLoads();
        return loadCheck(availableLoads, driver.getCarData());
    }

    @Override
    public List<LoadInformation> findAvailableLoadsByDestinationPoint(Driver driver) {
        return null;
    }
    private List<LoadInformation> loadCheck(List<LoadInformation> avLoads, CarData carData) {
        List<LoadInformation> checkedLoads = new ArrayList<>();
        for (LoadInformation load: avLoads) {
            if (carSuitabilityService.countCarSuitabilityForLoad(load, carData)) {
                checkedLoads.add(load);
            }
        }
        return checkedLoads;
    }
}
