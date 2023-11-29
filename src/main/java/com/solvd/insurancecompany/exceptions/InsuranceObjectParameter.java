package com.solvd.insurancecompany.exceptions;

public enum InsuranceObjectParameter {

    MIN_VEHICLE_PRICE(500),
    MIN_HOME_PRICE(2000),
    MIN_HOME_M2(5),
    MAX_STRING_LENGTH(50),
    BASE_HOME_M2_AREA(30),
    BASE_VEHICLE_PRICE(9999),
    BASE_HOME_PRICE(59999),
    BASE_VEHICLE_LEVEL_YEAR(2010);


    private final double value;

    InsuranceObjectParameter(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
