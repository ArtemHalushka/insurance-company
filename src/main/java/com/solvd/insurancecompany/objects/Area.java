package com.solvd.insurancecompany.objects;

public enum Area {

    HOME_M2_AREA(30);

    private final double value;

    Area(int value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
