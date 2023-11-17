package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.calculators.PriceCalculator;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;

import java.util.Date;

public class HealthInsurance extends Insurance {

    public HealthInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                           Date issueDate, Date endDate) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        finalPrice = PriceCalculator.calculateInsurancePrice(insuranceCustomer.getInsureObject());
    }


    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + "Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate();
    }
}

