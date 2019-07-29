package com.thamirestissot.core.desafio;

public enum DataType {
    SALESMAN(1), CUSTOMER(2), SALE(3);
    private int code;

    DataType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}