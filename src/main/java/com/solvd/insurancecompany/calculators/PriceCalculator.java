package com.solvd.insurancecompany.calculators;

import com.solvd.insurancecompany.objects.Health;
import com.solvd.insurancecompany.objects.Home;
import com.solvd.insurancecompany.objects.InsureObject;
import com.solvd.insurancecompany.objects.Vehicle;

public class PriceCalculator {

    public static double calculateInsurancePrice(InsureObject insureObject) {
        if (insureObject instanceof Vehicle) {
            return ((CalculatorValue.VEHICLE_PRICE_PERCENT.getValue() / 100) * ((Vehicle) insureObject).getPrice() * CalculatorValue.INSURANCE_COMPANY_COEFFICIENT.getValue());
        } else if (insureObject instanceof Home) {
            return ((CalculatorValue.HOME_PRICE_PERCENT.getValue() / 100) * ((Home) insureObject).getPrice() * CalculatorValue.INSURANCE_COMPANY_COEFFICIENT.getValue());
        } else if (insureObject instanceof Health) {
            if ((((Health) insureObject).getHealthDiseases().size()) == 0) {
                return CalculatorValue.MINIMAL_HEALTH_PRICE.getValue();
            }
            return ((CalculatorValue.HEALTH_PRICE_PERCENT.getValue() / 100) * ((((Health) insureObject).getHealthDiseases().size()) * 300)) * CalculatorValue.INSURANCE_COMPANY_COEFFICIENT.getValue();
        }
        return 0;
    }
}