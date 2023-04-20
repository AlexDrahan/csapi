package com.example.csapi.model;

import com.example.csapi.model.LiftGateDetails;
import com.example.csapi.model.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarData {
    String carId;
    CarType carType;
    CarDimensions carDims; //temp solution
    String carModel;
    String carYear;
    short payload;
    boolean dockHigh;
    boolean airRide;
    LiftGateDetails liftGateDetails;
}
