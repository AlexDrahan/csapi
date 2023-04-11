package com.example.csapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDimensions {
    double length;
    double width;
    double height;
    double doorWidth;
    double doorLength;
}
