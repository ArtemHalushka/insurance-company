package com.solvd.insurancecompany.objects;

public enum LuxuryLevel {

    HIGH_LEVEL("High Level"),
    MEDIUM_LEVEL("Medium Level"),
    LOW_LEVEL("Low Level");

    private final String description;

    Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
