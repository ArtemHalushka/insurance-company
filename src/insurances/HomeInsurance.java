package insurances;

import objects.Home;
import people.Customer;
import people.Employee;

public class HomeInsurance extends Insurance {

    private Home homeType;

    public HomeInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                         double price, String issueDate, String endDate, Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, price, issueDate, endDate);
        this.homeType = homeType;
    }

    @Override
    public String toString() {
        return "Insurance" + " " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " "
                + super.getPrice() + " " + super.getIssueDate() + " " + super.getEndDate() + " " + homeType;
    }
}
