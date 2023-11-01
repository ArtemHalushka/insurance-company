package insurances;

import people.Customer;
import people.Employee;

public class HealthInsurance extends Insurance {

    private String[] healthDiseases;
    private Boolean smoker;
    private String[] medications;

    public HealthInsurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer, double price,
                           String issueDate, String endDate, String[] healthDiseases, Boolean smoker, String[] medications) {
        super(insuranceName, issueEmployee, insuranceCustomer, price, issueDate, endDate);
        this.healthDiseases = healthDiseases;
        this.smoker = smoker;
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "Insurance" + " " + super.getInsuranceName() + " " + super.getIssueEmployee() + " " + super.getInsuranceCustomer() + " "
                + super.getPrice() + " " + super.getIssueDate() + " " + super.getEndDate();
    }
}

