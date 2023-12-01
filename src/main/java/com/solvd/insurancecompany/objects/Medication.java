package com.solvd.insurancecompany.objects;

public enum Medication {

    MEZIM("Mezim");

    private final String value;

    Medication(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
