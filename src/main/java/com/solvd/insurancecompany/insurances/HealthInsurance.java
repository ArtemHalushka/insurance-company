package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.calculators.CalculatorValue;
import com.solvd.insurancecompany.calculators.InsurancePriceCalculator;
import com.solvd.insurancecompany.objects.Health;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;

import java.util.Date;

public class HealthInsurance extends Insurance {

    public HealthInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                           Date issueDate, Date endDate) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        InsurancePriceCalculator<Health> priceCalculator = insureObject -> {
            if (Health.getHealthDiseases().size() == 0) {
                CalculatorValue.MINIMAL_HEALTH_PRICE.getValue();
            }
            finalPrice = (CalculatorValue.HEALTH_PRICE_PERCENT.getValue() / 100) * ((Health.getHealthDiseases().size()) * 300) * CalculatorValue.INSURANCE_COMPANY_COEFFICIENT.getValue();
            return finalPrice;
        };
    }




    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + "Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate();
    }
}

