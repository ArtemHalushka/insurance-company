package insurances;

import insurancePrice.VehiclePrice;
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

        VehiclePrice vehiclePriceCalculate = new VehiclePrice();
        finalPrice = vehiclePriceCalculate.countPrice(vehicleType);
    }

    @Override
    public String toString() {
        return "Insurance: " + "id (" + insuranceId + ") " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + vehicleType;
    }
}

