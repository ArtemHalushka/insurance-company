package people;

import java.util.Date;
import objects.Health;
import objects.InsureObject;
import objects.Vehicle;
import objects.Home;

import java.util.Date;

public class Customer extends Person {

    private InsureObject object;

    public Customer(String name, String birthDate, String address, String phoneNumber, String[] healthDiseases, Boolean smoker, String[] medications) {
        super(name, birthDate, address, phoneNumber);
        this.object = new Health(healthDiseases, smoker, medications);
    }

    public Customer(String name, String birthDate, String address, String phoneNumber, String vehicleType, double price, String fuel, int year) {
        super(name, birthDate, address, phoneNumber);
        this.object = new Vehicle(vehicleType, price, fuel, year);
    }

    public Customer(String name, String birthDate, String address, String phoneNumber, String homeType, double price, int m2) {
        super(name, birthDate, address, phoneNumber);
        this.object = new Home(homeType, price, m2);
    }

    public InsureObject getInsureObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " +
                super.getPhoneNumber() + " " + object;
    }
}