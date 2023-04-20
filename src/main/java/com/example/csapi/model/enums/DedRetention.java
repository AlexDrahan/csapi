package com.example.csapi.model.enums;

public enum DedRetention {
    FIVE_THOUSAND(5000),
    TEN_THOUSAND(10000),
    FIFTEEN_THOUSAND(15000);

    private final int value;

    DedRetention(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
