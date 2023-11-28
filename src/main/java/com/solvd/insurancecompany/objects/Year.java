package com.solvd.insurancecompany.objects;

public enum Year {

    VEHICLE_LEVEL_YEAR(2010);

    private final int value;

    Year(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
