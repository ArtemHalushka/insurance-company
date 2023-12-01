package com.solvd.insurancecompany.objects;

public enum Medication {

    MEZIM("Mezim");

    private final String value;

    Medications(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
