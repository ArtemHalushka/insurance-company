package com.solvd.insurancecompany.objects;

public enum HealthDiseases {

    DIABETES("Diabetes"),
    HIGH_BLOOD_PRESSURE("High blood pressure");

    private final String value;

    HealthDiseases(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
