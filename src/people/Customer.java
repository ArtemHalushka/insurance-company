package people;

import company.InsuranceCompany;
import insurances.IRequest;
import insurances.InsuranceRequest;
import objects.Health;
import objects.InsureObject;
import objects.Vehicle;
import objects.Home;

public class Customer extends Person implements IRequest {

    private InsureObject object;
    private int personId = (int) (Math.random() * 10001);



    public Customer(String name, String birthDate, String address, String phoneNumber, String[] healthDiseases, Boolean smoker, String[] medications) {
        super(name, birthDate, address, phoneNumber);
        this.object = new Health(healthDiseases, smoker, medications);
        this.personId = personId;
    }

    public Customer(String name, String birthDate, String address, String phoneNumber, String vehicleType, double price, String fuel, int year) {
        super(name, birthDate, address, phoneNumber);
        this.object = new Vehicle(vehicleType, price, fuel, year);
    }

    public Customer(String name, String birthDate, String address, String phoneNumber, String homeType, double price, int m2) {
        super(name, birthDate, address, phoneNumber);
        this.object = new Home(homeType, price, m2);
    }

    @Override
    public InsuranceRequest requestInsurance(InsuranceCompany company) {
        InsuranceRequest request = new InsuranceRequest(this);
        company.addRequest(request);
        return request;
    }
    public InsureObject getInsureObject() { return object; }

    @Override
    public String toString() {

        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " +
                super.getPhoneNumber() + " " + object;
    }
}
