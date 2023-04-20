package com.example.csapi.exceptions;

public class NoSuchBidException extends RuntimeException {

    public NoSuchBidException(String msg) {
        super(msg);
    }
}
