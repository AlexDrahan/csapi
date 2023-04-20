package com.example.csapi.exceptions;

public class NoSuchLoadException extends RuntimeException {

    public NoSuchLoadException(String msg) {
        super(msg);
    }
}
