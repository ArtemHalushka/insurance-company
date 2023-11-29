package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.calculators.CalculatorValue;
import com.solvd.insurancecompany.calculators.InsurancePriceCalculator;
import com.solvd.insurancecompany.objects.Home;
import com.solvd.insurancecompany.objects.LuxuryLevel;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;

import java.util.Date;

public class HomeInsurance extends Insurance {

    private Home homeType;

    public HomeInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                         Date issueDate, Date endDate, Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.homeType = homeType;
        InsurancePriceCalculator<Home> priceCalculator = insureObject -> {
            finalPrice = (CalculatorValue.HOME_PRICE_PERCENT.getValue() / 100) * homeType.getPrice() * CalculatorValue.INSURANCE_COMPANY_COEFFICIENT.getValue();
            if (LuxuryLevel.HIGH_LEVEL.equals(homeType.insuranceObjectLevel())) {
                finalPrice -= finalPrice / 10;
            }
            if (LuxuryLevel.LOW_LEVEL.equals(homeType.insuranceObjectLevel())) {
                finalPrice += finalPrice / 10;
            }
            return finalPrice;
        };
    }
    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + homeType;
    }
}