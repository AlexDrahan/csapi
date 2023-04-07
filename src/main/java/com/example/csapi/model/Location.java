package com.example.csapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    String state;
    String city;
    String address;
    String zipCode;
    String details;
}
