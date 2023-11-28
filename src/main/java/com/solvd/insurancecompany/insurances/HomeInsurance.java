package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.calculators.PriceCalculator;
import com.solvd.insurancecompany.objects.Home;
import com.solvd.insurancecompany.objects.ILevel;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;

import java.util.Date;

public class HomeInsurance extends Insurance {

    private Home homeType;

    public HomeInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                         Date issueDate, Date endDate, Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.homeType = homeType;
        finalPrice = PriceCalculator.calculateInsurancePrice(homeType);
        if (ILevel.HIGH_LEVEL.equals(homeType.insuranceObjectLevel())) {
            finalPrice = finalPrice - (finalPrice / 10);
        }
        if (ILevel.LOW_LEVEL.equals(homeType.insuranceObjectLevel())) {
            finalPrice = finalPrice + (finalPrice / 10);
        }
    }

    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + homeType;
    }
}