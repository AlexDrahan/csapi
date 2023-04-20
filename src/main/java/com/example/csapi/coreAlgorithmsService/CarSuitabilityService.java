package com.example.csapi.coreAlgorithmsService;

import com.example.csapi.model.CarData;
import com.example.csapi.model.validations.LoadInformation;

public interface CarSuitabilityService {

    boolean countCarSuitabilityForLoad(LoadInformation loadInformation, CarData car);
}
