package com.example.csapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentMethod {
    private String name;
    private String cardNumber;
    private String expirationDate;
    private String cvv;
}