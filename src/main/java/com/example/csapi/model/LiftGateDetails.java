package com.example.csapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiftGateDetails {
    boolean liftGate;
    int liftGatePayload;
}
