package com.example.csapi.web_service;

import com.example.csapi.model.Bid;

public interface BidService {
    Bid createABid(String driverId, Bid bid);
    void deleteBid(String id);
    Bid findById( String id);
}
