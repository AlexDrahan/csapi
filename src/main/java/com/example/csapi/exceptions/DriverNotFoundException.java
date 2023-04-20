package com.example.csapi.exceptions;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(String id) {
        super("Driver not found with id " + id);
    }
}
