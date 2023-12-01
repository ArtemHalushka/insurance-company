package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.calculators.CalculatorValue;
import com.solvd.insurancecompany.calculators.HealthInsurancePriceCalculator;
import com.solvd.insurancecompany.calculators.InsurancePriceCalculator;
import com.solvd.insurancecompany.objects.Health;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;

import java.util.Date;

public class HealthInsurance extends Insurance {

    public HealthInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                           Date issueDate, Date endDate) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        HealthInsurancePriceCalculator<Customer> priceCalculator = insureCustomer -> {
            if (insureCustomer.getHealth().getHealthDiseases().size() == 0) {
                return CalculatorValue.MINIMAL_HEALTH_PRICE.getValue();
            }
            finalPrice = (CalculatorValue.HEALTH_PRICE_PERCENT.getValue() / 100) * ((insureCustomer.getHealth().getHealthDiseases().size()) * 300) * CalculatorValue.INSURANCE_COMPANY_COEFFICIENT.getValue();
            return finalPrice;
        };
        finalPrice = priceCalculator.calculateHealthInsurancePrice(insuranceCustomer);
    }

    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + "Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate();
    }
}

