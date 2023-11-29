package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.calculators.PriceCalculator;
import com.solvd.insurancecompany.objects.LuxuryLevel;
import com.solvd.insurancecompany.people.Employee;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.objects.Vehicle;
import java.util.Date;

public class VehicleInsurance extends Insurance {

    private Vehicle vehicleType;

    public VehicleInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                            Date issueDate, Date endDate, Vehicle vehicleType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.vehicleType = vehicleType;
        finalPrice = PriceCalculator.calculateInsurancePrice(vehicleType);
        if (LuxuryLevel.HIGH_LEVEL.equals(vehicleType.insuranceObjectLevel())) {
            finalPrice = finalPrice - (finalPrice / 10);
        }
        if (LuxuryLevel.LOW_LEVEL.equals(vehicleType.insuranceObjectLevel())) {
            finalPrice = finalPrice + (finalPrice / 10);
        }
    }

    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + vehicleType;
    }
}