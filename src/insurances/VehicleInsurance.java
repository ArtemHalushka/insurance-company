package insurances;

import people.Employee;
import people.Customer;
import objects.Vehicle;

public class VehicleInsurance extends Insurance {

    private Vehicle vehicleType;

    public VehicleInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                            double price, String issueDate, String endDate, Vehicle vehicleType) {
        super(insuranceName, issueEmployee, insuranceCustomer, price, issueDate, endDate);
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Insurance" + " " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " "
                + super.getPrice() + " " + super.getIssueDate() + " " + super.getEndDate() + " " + vehicleType;
    }
}

