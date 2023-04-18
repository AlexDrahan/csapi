package com.example.csapi.exceptions;

public class NoSuchDriverException extends RuntimeException {

    public NoSuchDriverException(String msg) {
        super(msg);
    }
}
