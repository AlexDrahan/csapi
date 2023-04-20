package com.example.csapi.web_controller;

import com.example.csapi.exceptions.LicenseExpiredException;
import com.example.csapi.web_service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/{driverId}/deactivateIfLicenseExpired")
    public ResponseEntity<Void> deactivateDriverIfLicenseExpired(@PathVariable String driverId) throws LicenseExpiredException {
        driverService.deactivateDriverIfLicenseExpired(driverId);
        return ResponseEntity.ok().build();
    }



}
