package com.solvd.insurancecompany.objects;

public enum Price {

    VEHICLE_PRICE(9999),
    HOME_PRICE(59999);

    private final int value;

    Price(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
