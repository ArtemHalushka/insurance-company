package insurances;

import insurancePrice.HealthPrice;
import people.Customer;
import people.Employee;

public class HealthInsurance extends Insurance {

    private String[] healthDiseases;
    private Boolean smoker;
    private String[] medications;
    private static int insuranceId = 3;
    private double finalPrice;

    public HealthInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                           String issueDate, String endDate, String[] healthDiseases, Boolean smoker, String[] medications) {
        super(insuranceName, issueEmployee, insuranceCustomer, issueDate, endDate);
        this.healthDiseases = healthDiseases;
        this.smoker = smoker;
        this.medications = medications;

        HealthPrice healthPriceCalculate = new HealthPrice();
        finalPrice = healthPriceCalculate.countPrice(healthDiseases);
    }

    @Override
    public String toString() {
        return "Insurance: " + "id (" + insuranceId + ") " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + "Price "
                + finalPrice + " " + super.getIssueDate() + " " + super.getEndDate();
    }
}

