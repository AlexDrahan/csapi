package com.example.csapi.web_service;

import com.example.csapi.model.Bid;
import com.example.csapi.model.Location;
import com.example.csapi.model.documets.Coi;
import com.example.csapi.model.validations.Driver;
import com.example.csapi.model.validations.LoadInformation;

import java.util.List;

public interface DriverService {

    Driver createDriver(Driver driver);
    Driver editDriver(String id, Driver driver);
    void deleteDriver(String id);

    //Bid should be avaliable for 15 minutes (can be added more time)
    Bid putBidForLoad(String loadId, String id, Bid bid);
    void cancelBidForLoad(String driverId, String bidId);

    //Also, app should automatically count expiring
    Coi updateCOI(String driverId, Coi coi);
    Driver changeCurrentLocation(String id, Location currentLocation);
    Driver findDriverById(String id);
    List<Driver> findDriverByLocation(Location currentLocation);
    List<Driver> findAllDrivers();
    List<LoadInformation> findAvailableLoads(Driver driver);
    List<LoadInformation> findAvailableLoadsByDestinationPoint(Driver driver);
}
