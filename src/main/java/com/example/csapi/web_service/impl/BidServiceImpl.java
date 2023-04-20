package com.example.csapi.web_service.impl;

import com.example.csapi.exceptions.NoSuchBidException;
import com.example.csapi.model.Bid;
import com.example.csapi.repository.BidRepository;
import com.example.csapi.web_service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;
    @Override
    public Bid createABid(String driverId, Bid bid) {
        bid.setDriverId(driverId);
        return bidRepository.save(bid);
    }

    @Override
    public void deleteBid(String id) {
        bidRepository.deleteById(id);
    }

    @Override
    public Bid findById(String id) {
        Optional<Bid> optionalBid = bidRepository.findById(id);
        if (optionalBid.isPresent()) {
            return optionalBid.get();
        } else {
            throw new NoSuchBidException("No bid was found");
        }
    }
}
