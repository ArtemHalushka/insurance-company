package com.solvd.insurancecompany.objects;

public enum LuxuryLevel {

    HIGH_LEVEL("High Level"),
    MEDIUM_LEVEL("Medium Level"),
    LOW_LEVEL("Low Level");

    private final String description;

    LuxuryLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
