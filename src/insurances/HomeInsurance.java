package insurances;

import insurancePrice.HomePrice;
import objects.Home;
import people.Customer;
import people.Employee;

public class HomeInsurance extends Insurance {

    private Home homeType;
    private static int insuranceId = 2;
    private double finalPrice;


    public HomeInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                          String issueDate, String endDate, Home homeType) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.homeType = homeType;

        HomePrice homePriceCalculate = new HomePrice();
        finalPrice = homePriceCalculate.countPrice(homeType);
    }

    @Override
    public String toString() {
        return "Insurance: " + "id (" + insuranceId + ") " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate() + " " + homeType;
    }
}
