package insurances;

import calculators.PriceCalculator;
import objects.Home;
import objects.ILevel;
import people.Customer;
import people.Employee;

import java.util.Date;

public class HomeInsurance extends Insurance {

    private Home homeType;

    public HomeInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                         Date issueDate, Date endDate, Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.homeType = homeType;
        finalPrice = PriceCalculator.calculateInsurancePrice(homeType);
        if (ILevel.HIGH_LEVEL.equals(homeType.insuranceObjectLevel())) {
            finalPrice = finalPrice - (finalPrice / 10);
        }
        if (ILevel.LOW_LEVEL.equals(homeType.insuranceObjectLevel())) {
            finalPrice = finalPrice + (finalPrice / 10);
        }
    }

    @Override
    public String toString() {
        return "Insurance: " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + homeType;
    }
}