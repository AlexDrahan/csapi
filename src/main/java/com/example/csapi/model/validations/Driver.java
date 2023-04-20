package com.example.csapi.model.validations;


import com.example.csapi.model.documets.Coi;
import com.example.csapi.model.Location;
import com.example.csapi.model.enums.WorkDocuments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("drivers")
public class Driver {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
//    @Max(value = 30, message = "Max length of a first name should be less than 30 letters")
    private String driverFirstName;
//    @Max(value = 30, message = "Max length of a last name should be less than 30 letters")
    private String driverLastName;
    private String driverPhoneNumber;
    private String driverEmail;

    //Certificate of Insurance
    private Coi cInsurance;
    private String homeLocation;
    boolean isTeam;
    boolean isTracked;
    boolean canadaFreights;
    private String details;
    private WorkDocuments workDocuments;
    private Location currentLocation;
    private boolean isActive;

    private LocalDate licenseExpirationDate;

    public boolean isLicenseValid() {
        return licenseExpirationDate.isAfter(LocalDate.now());
    }

    public void deactivateDriver() {
        isActive = false;
    }
}

