package com.example.csapi.model.validations;


import com.example.csapi.model.enums.WorkDocuments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("drivers")
public class Driver {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
//    @Max(value = 30, message = "Max length of a first name should be less than 30 letters")
    String driverFirstName;
//    @Max(value = 30, message = "Max length of a last name should be less than 30 letters")
    String driverLastName;
    String driverPhoneNumber;
    String driverEmail;
    String homeLocation;
    boolean isTeam;
    boolean isTracked;
    boolean canadaFreights;
    String details;
    WorkDocuments workDocuments;

}
