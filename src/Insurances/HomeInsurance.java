package Insurances;

import objects.Home;
import people.Customer;
import people.Employee;

public class HomeInsurance extends Insurance {
    private Home homeType;

    public HomeInsurance(
            String insuranceName,
            Employee issueEmployee,
            Customer insuranceCustomer,
            int price,
            String issueDate,
            String endDate,
            Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, price, issueDate, endDate);
        this.homeType = homeType;
    }
}
