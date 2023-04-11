package com.example.csapi.web_controller;

import com.example.csapi.web_service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("broker")
public class BrokerController {
    @Autowired
    BrokerService brokerService;


}
