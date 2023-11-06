package people;

import insurances.*;
import insurances.VehicleInsurance;
import objects.*;


public class Employee extends Person implements IIssue {

    private String position;
    private static int personId = 2;

    public Employee(String name, String birthDate, String address, int phoneNumber, String position) {
        super(name, birthDate, address, phoneNumber);
        this.position = position;
    }

    @Override
    public VehicleInsurance issueVehicleInsurance(Customer customer, String insuranceName, String issueDate,
                                                  String endDate, Vehicle vehicle) {

        VehicleInsurance insurance = new VehicleInsurance(insuranceName, this, customer,
                 issueDate, endDate, vehicle);
        return insurance;
    }

    @Override
    public HealthInsurance issueHealthInsurance(Customer customer, String insuranceName, String issueDate, String endDate,
                                                String[] healthDiseases, Boolean smoker, String[] medications) {

        HealthInsurance insurance = new HealthInsurance(insuranceName, this, customer, issueDate,
                endDate, healthDiseases, smoker, medications);
        return insurance;
    }

    @Override
    public HomeInsurance issueHomeInsurance(Customer customer, String insuranceName,
                                            String issueDate, String endDate, Home home) {

        HomeInsurance insurance = new HomeInsurance(insuranceName, this, customer, issueDate, endDate, home);
        return insurance;
    }

    @Override
    public String toString() {
        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " + super.getPhoneNumber() + " " + position;
    }
}


