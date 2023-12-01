package com.solvd.insurancecompany.objects;

public enum HealthDisease {

    DIABETES("Diabetes"),
    HIGH_BLOOD_PRESSURE("High blood pressure");

    private final String value;

    HealthDisease(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
