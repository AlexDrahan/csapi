package com.example.csapi.exceptions;

public class LicenseExpiredException extends Exception {
    public LicenseExpiredException(String message) {
        super(message);
    }
}

