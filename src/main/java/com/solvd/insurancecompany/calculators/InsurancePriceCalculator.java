package com.solvd.insurancecompany.calculators;

import com.solvd.insurancecompany.objects.InsureObject;

@FunctionalInterface
public interface InsurancePriceCalculator<T extends InsureObject> {

    double calculateInsurancePrice(T insureObject);
}
