package insurances;

import people.Customer;
import people.Employee;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Insurance self = (Insurance) object;

        return Objects.equals(insuranceName, self.insuranceName) && Objects.equals(insuranceCustomer, self.insuranceCustomer)
                && Objects.equals(issueDate, self.issueDate) && Objects.equals(endDate, self.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insuranceName, insuranceCustomer, issueDate, endDate);
    }
}
