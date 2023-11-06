package people;

import java.util.Arrays;

public class Customer extends Person {

    private String[] healthDiseases;
    private Boolean smoker;
    private String[] medications;
    private static int insurancePersonId = 1;

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
    public String toString() {
        String healthDiseasesString = Arrays.toString(healthDiseases);
        String medicationsString = Arrays.toString(medications);

        return "Person: " + "id (" + insurancePersonId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " +
                super.getPhoneNumber() + " " + healthDiseasesString + " " + "smoker " + smoker + " " + medicationsString;
    }
}
