package people;

import java.util.Arrays;

import company.InsuranceCompany;
import insurances.IRequest;
import insurances.Insurance;
import insurances.InsuranceRequest;

public class Customer extends Person implements IRequest {

    private String[] healthDiseases;
    private Boolean smoker;
    private String[] medications;
    private static int personId = 1;

    public Customer(String name, String birthDate, String address, int phoneNumber) {
        super(name, birthDate, address, phoneNumber);
    }

    public Customer(String name, String birthDate, String address, int phoneNumber, String[] healthDiseases, Boolean smoker, String[] medications) {
        super(name, birthDate, address, phoneNumber);
        this.healthDiseases = healthDiseases;
        this.smoker = smoker;
        this.medications = medications;
    }

    @Override
    public InsuranceRequest requestInsurance(InsuranceCompany company, Object insureObject) {
        InsuranceRequest request = new InsuranceRequest(this, company, insureObject);
        company.addRequest(request);
        return request;
    }

    @Override
    public String toString() {
        String healthDiseasesString = Arrays.toString(healthDiseases);
        String medicationsString = Arrays.toString(medications);

        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " +
                super.getPhoneNumber() + " " + healthDiseasesString + " " + "smoker " + smoker + " " + medicationsString;
    }
}
