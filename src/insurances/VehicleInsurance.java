package insurances;

import calculators.PriceCalculator;
import people.Employee;
import people.Customer;
import objects.Vehicle;

public class VehicleInsurance extends Insurance {

    private Vehicle vehicleType;
    private static int insuranceId = 1;
    private double finalPrice;

    public VehicleInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                            String issueDate, String endDate, Vehicle vehicleType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.vehicleType = vehicleType;

        finalPrice = PriceCalculator.calculateVehiclePrice(vehicleType);
        if (vehicleType.prioritizeInsuranceObject().equals("High priority")) {
            finalPrice = finalPrice - (finalPrice/20);
        }
        if (vehicleType.prioritizeInsuranceObject().equals("Low priority")) {
            finalPrice = finalPrice + (finalPrice/20);
        }
    }

    @Override
    public String toString() {
        return "Insurance: " + "id (" + insuranceId + ") " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + vehicleType;
    }
}

