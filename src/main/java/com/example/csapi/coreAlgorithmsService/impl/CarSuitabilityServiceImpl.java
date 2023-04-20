package com.example.csapi.coreAlgorithmsService.impl;

import com.example.csapi.coreAlgorithmsService.CarSuitabilityService;
import com.example.csapi.model.CarData;
import com.example.csapi.model.CarDimensions;
import com.example.csapi.model.Dimensions;
import com.example.csapi.model.enums.CarType;
import com.example.csapi.model.enums.PayloadIndicator;
import com.example.csapi.model.validations.LoadInformation;
import org.springframework.stereotype.Service;

@Service
public class CarSuitabilityServiceImpl implements CarSuitabilityService {
    @Override
    public boolean countCarSuitabilityForLoad(LoadInformation loadInformation, CarData car) {
        // need to be added other checks (LG, PJ, DOCK_HIGH)
        return carDimensions(loadInformation, car)
                && carType(loadInformation, car)
                && carPayload(loadInformation, car);
    }


    /**
     * Algorithm which counts either the cargo (pallets) fit the truck or not using
     * load dimensions and truck dimensions
     */
    private boolean carDimensions(LoadInformation loadInformation, CarData carData) {
        int palletCount = loadInformation.getAmount();
        Dimensions palletDims = loadInformation.getDims();
        CarDimensions carDims = carData.getCarDims();
        double doorWidth = carDims.getDoorWidth();
        boolean rotatable = loadInformation.getIsRotatable();

        // Check if the pallets can fit through the car door
        if (palletDims.getWidth() > doorWidth) {
            return false;
        }

        // Check if the pallets can fit in the car by width and height
        double palletWidth = palletDims.getWidth();
        double palletHeight = palletDims.getHeight();
        double palletLength = palletDims.getLength();
        double carWidth = carDims.getWidth();
        double carHeight = carDims.getHeight();
        double carLength = carDims.getLength();

        if (!rotatable) {
            // Check if the pallets can fit in the car by width and height without rotating
            double totalPalletWidth = palletWidth * palletCount + 2.0;
            double totalPalletHeight = palletHeight + 2.0;
            if (totalPalletWidth > carWidth || totalPalletHeight > carHeight) {
                return false;
            }
        } else {
            // Check if the pallets can fit in the car by width and height with rotation
            double totalPalletWidth = palletWidth + 2.0;
            double totalPalletHeight = palletHeight * palletCount + 2.0;
            if (totalPalletWidth > carWidth || totalPalletHeight > carHeight) {
                // Try rotating the pallets
                totalPalletWidth = palletHeight + 2.0;
                totalPalletHeight = palletWidth * palletCount + 2.0;
                if (totalPalletWidth > carWidth || totalPalletHeight > carHeight) {
                    return false;
                }
            }
        }
        // Check if the pallets can fit in the car by length
        double totalPalletLength = palletLength * palletCount + 2.0;
        if (totalPalletLength > carLength) {
            return false;
        }
        // The pallets fit in the car
        return true;
    }


    /**
     * TEMPORARY SOLUTION
     * Algorithm which counts either the truck type is the same as needed
     */
    private boolean carType(LoadInformation loadInformation, CarData carData) {
        CarType neededCarType = loadInformation.getNeededCarType();
        CarType carType = carData.getCarType();

        // check for specific truck types
        if (neededCarType == CarType.TRACTOR && carType != CarType.TRACTOR) {
            return false;
        } else if (neededCarType == CarType.FLATBED && carType != CarType.FLATBED) {
            return false;
        }

        // check for other truck types
        if (carType == neededCarType) {
            return true;
        } else if (carType == CarType.SPRINTER_VAN && neededCarType == CarType.CARGO_VAN
                || carType == CarType.BOX_TRUCK_HARD_SIDE && neededCarType == CarType.CARGO_VAN
                || carType == CarType.BOX_TRUCK_CURTAIN_SIDE && neededCarType == CarType.CARGO_VAN) {
            return true;
        } else if (carType == CarType.BOX_TRUCK_HARD_SIDE && neededCarType == CarType.SPRINTER_VAN
                || carType == CarType.BOX_TRUCK_CURTAIN_SIDE && neededCarType == CarType.SPRINTER_VAN) {
            return true;
        } else if (carType == CarType.BOX_TRUCK_CURTAIN_SIDE && (neededCarType == CarType.BOX_TRUCK_HARD_SIDE
                || neededCarType == CarType.CONESTOGA)) {
            return true;
        } else if (carType == CarType.LARGE_STRAIGHT && (neededCarType == CarType.CARGO_VAN
                || neededCarType == CarType.SPRINTER_VAN
                || neededCarType == CarType.BOX_TRUCK_HARD_SIDE
                || neededCarType == CarType.BOX_TRUCK_CURTAIN_SIDE
                || neededCarType == CarType.CONESTOGA)) {
            return true;
        } else if (carType == CarType.CONESTOGA && (neededCarType == CarType.CARGO_VAN
                || neededCarType == CarType.SPRINTER_VAN
                || neededCarType == CarType.BOX_TRUCK_HARD_SIDE
                || neededCarType == CarType.BOX_TRUCK_CURTAIN_SIDE)
        ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Algorithm which counts either the cargo (pallets) fit the truck or not using
     * the payload
     */
    private boolean carPayload(LoadInformation loadInformation, CarData carData) {
        PayloadIndicator payloadIndicator;
        short cargoPayload = loadInformation.getPayload();
        short carPayload = carData.getPayload();

        if (cargoPayload < carPayload) {
                if (cargoPayload <= carPayload * 0.5) {
                    payloadIndicator = PayloadIndicator.GOOD;
                } else if (cargoPayload > carPayload * 0.5 && cargoPayload <= carPayload * 0.85) {
                    payloadIndicator = PayloadIndicator.NORMAL;
                } else {
                    payloadIndicator = PayloadIndicator.WARNING;
                }
                return true;
        }
        else {
            return false;
        }
    }
}
