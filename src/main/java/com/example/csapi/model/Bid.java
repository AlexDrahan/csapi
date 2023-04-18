package com.example.csapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("bids")
public class Bid {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private short rate;

    //Estimated time of arrival
    private String ETA;

    // Transit time
    private String TT;
    private boolean team;

    private CarDimensions carDimensions;

    private String additionalInfo;

}
