package com.solvd.insurancecompany.exceptions;

public enum InsuranceObjectParameter {

    INVALID_VEHICLE_PRICE(500),
    INVALID_HOME_PRICE(2000),
    INVALID_HOME_M2(5),
    INVALID_STRING_LENGTH(50);

    private final double value;

    InsuranceObjectParameter(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
