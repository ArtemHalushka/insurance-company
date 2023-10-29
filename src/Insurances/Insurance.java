package Insurances;

import people.Customer;
import people.Employee;

public class Insurance {
    private String insuranceName;
    private Employee issueEmployee;
    private Customer insuranceCustomer;
    private int price;
    private String issueDate;
    private String endDate;

    public Insurance(
            String insuranceName,
            Employee issueEmployee,
            Customer insuranceCustomer,
            int price,
            String issueDate,
            String endDate) {
        this.insuranceName = insuranceName;
        this.issueEmployee = issueEmployee;
        this.insuranceCustomer = insuranceCustomer;
        this.price = price;
        this.issueDate = issueDate;
        this.endDate = endDate;

    }
}
