package insurances;

import calculators.PriceCalculator;
import objects.Health;
import people.Customer;
import people.Employee;

public class HealthInsurance extends Insurance {

    private double finalPrice;

    public HealthInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                           String issueDate, String endDate) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);

        finalPrice = PriceCalculator.calculateInsurancePrice(insuranceCustomer.getInsureObject());
    }

    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + "Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate();
    }
}

