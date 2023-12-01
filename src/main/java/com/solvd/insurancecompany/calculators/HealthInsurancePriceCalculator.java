package com.solvd.insurancecompany.calculators;

import com.solvd.insurancecompany.people.Person;

@FunctionalInterface
public interface HealthInsurancePriceCalculator <T extends Person> {

    double calculateHealthInsurancePrice(T insureCustomer);
}

