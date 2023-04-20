package com.example.csapi.web_service;

import com.example.csapi.model.Bid;
import com.example.csapi.model.validations.LoadInformation;

import java.util.List;

public interface LoadService {
    LoadInformation putABid(String loadId, String driverId, Bid bid);
    LoadInformation findALoad(String id);
    List<LoadInformation> findAllLoads();
}
