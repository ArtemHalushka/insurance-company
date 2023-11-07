package insurances;

import calculators.PriceCalculator;
import objects.Home;
import people.Customer;
import people.Employee;

public class HomeInsurance extends Insurance {

    private Home homeType;
    private static int insuranceId = 1;
    private double finalPrice;


    public HomeInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                          String issueDate, String endDate, Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.homeType = homeType;

        finalPrice = PriceCalculator.calculateHomePrice(homeType);
        if (homeType.prioritizeInsuranceObject().equals("High priority")) {
            finalPrice = finalPrice - (finalPrice/10);
        }
        if (homeType.prioritizeInsuranceObject().equals("Low priority")) {
            finalPrice = finalPrice + (finalPrice/10);
        }

    }

    @Override
    public String toString() {
        return "Insurance: " + "id (" + insuranceId + ") " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + homeType;
    }
}
