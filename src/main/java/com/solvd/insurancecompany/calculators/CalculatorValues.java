package com.solvd.insurancecompany.calculators;

public enum CalculatorValue {

    INSURANCE_COMPANY_COEFFICIENT(10),
    HOME_PRICE_PERCENT(0.1),
    VEHICLE_PRICE_PERCENT(0.3),
    HEALTH_PRICE_PERCENT(2),
    MINIMAL_HEALTH_PRICE(10);

    private final double value;

    CalculatorValues(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
