package insurances;

import people.Customer;
import people.Employee;

public class Insurance {

    private String insuranceName;
    private Employee issueEmployee;
    private Customer insuranceCustomer;
    private double price;
    private String issueDate;
    private String endDate;

    public Insurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                     double price, String issueDate, String endDate) {
        this.insuranceName = insuranceName;
        this.issueEmployee = issueEmployee;
        this.insuranceCustomer = insuranceCustomer;
        this.price = price;
        this.issueDate = issueDate;
        this.endDate = endDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public Employee getIssueEmployee() {
        return issueEmployee;
    }

    public Customer getInsuranceCustomer() {
        return insuranceCustomer;
    }

    public double getPrice() {
        return price;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
