package com.example.csapi.web_service.impl;

import com.example.csapi.exceptions.NoSuchLoadException;
import com.example.csapi.model.Bid;
import com.example.csapi.model.validations.LoadInformation;
import com.example.csapi.repository.LoadRepository;
import com.example.csapi.web_service.BidService;
import com.example.csapi.web_service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {
    @Autowired
    private LoadRepository loadRepository;
    @Autowired
    private BidService bidService;

    //Puts a Bid and updates Load (list of bids)
    @Override
    public LoadInformation putABid(String loadId, String driverId, Bid bid) {
        Bid bidToPlay = bidService.createABid(driverId, bid);

        //Add a bid for load
        LoadInformation loadToAddABid = findALoad(loadId);
        List<Bid> listToUpdate = loadToAddABid.getCurrentBids();
        listToUpdate.add(bidToPlay);

        //Save updated list
        return loadRepository.save(loadToAddABid);
    }

    @Override
    public LoadInformation findALoad(String id) {
        Optional<LoadInformation> optionalLoad = loadRepository.findById(id);
        if (optionalLoad.isPresent()) {
            return optionalLoad.get();
        } else {
            throw new NoSuchLoadException("No such a load with this id");
        }
    }

    @Override
    public List<LoadInformation> findAllLoads() {
        return loadRepository.findAll();
    }
}
