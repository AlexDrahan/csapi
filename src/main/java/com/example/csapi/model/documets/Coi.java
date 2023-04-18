package com.example.csapi.model.documets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coi {
    private String certificateNumber;
    private String policyCarrier;

    //Type of coverage and limits
    private List<Coverages> coverages;
}
