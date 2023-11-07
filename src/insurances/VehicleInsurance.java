package insurances;

import calculators.PriceCalculator;
import objects.IPrioritize;
import people.Employee;
import people.Customer;
import objects.Vehicle;

public class VehicleInsurance extends Insurance {

    private Vehicle vehicleType;
    private double finalPrice;

    public VehicleInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                            String issueDate, String endDate, Vehicle vehicleType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.vehicleType = vehicleType;

        finalPrice = PriceCalculator.calculateInsurancePrice(vehicleType);
        if ((IPrioritize.HIGH_LEVEL).equals(vehicleType.insuranceObjectLevel())) {
            finalPrice = finalPrice - (finalPrice / 10);
        }
        if ((IPrioritize.LOW_LEVEL).equals(vehicleType.insuranceObjectLevel())) {
            finalPrice = finalPrice + (finalPrice / 10);
        }
    }

    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + vehicleType;
    }
}

