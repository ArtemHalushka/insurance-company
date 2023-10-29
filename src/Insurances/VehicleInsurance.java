package Insurances;

import people.Employee;
import people.Customer;
import objects.Vehicle;

public class VehicleInsurance extends Insurance {
    private Vehicle vehicleType;

    public VehicleInsurance(
            String insuranceName,
            Employee issueEmployee,
            Customer insuranceCustomer,
            int price,
            String issueDate,
            String endDate,
            Vehicle vehicleType) {
        super(insuranceName, issueEmployee, insuranceCustomer, price, issueDate, endDate);
        this.vehicleType = vehicleType;
    }
}
