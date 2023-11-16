package people;

import exceptions.StringLengthException;
import objects.Health;
import objects.InsureObject;
import objects.Vehicle;
import objects.Home;

import java.util.Date;

public class Customer extends Person {

    private InsureObject object;
    private Health health;

    public Customer(String name, Date birthDate, String address, String phoneNumber, Boolean smoker) throws StringLengthException {
        super(name, birthDate, address, phoneNumber);
        this.health = new Health(smoker);
    }

    public Customer(String name, Date birthDate, String address, String phoneNumber, String vehicleType, double price, String fuel, int year) throws StringLengthException {
        super(name, birthDate, address, phoneNumber);
        this.object = new Vehicle(vehicleType, price, fuel, year);
    }

    public Customer(String name, Date birthDate, String address, String phoneNumber, String homeType, double price, int m2) throws StringLengthException {
        super(name, birthDate, address, phoneNumber);
        this.object = new Home(homeType, price, m2);
    }

    public InsureObject getInsureObject() {
        return object;
    }
    public Health getHealth() { return health; }

    public void addHealthDisease(String disease) {
        health.addHealthDisease(disease);
    }

    public void removeHealthDisease(String disease) {
        health.removeHealthDisease(disease);
    }

    public void addMedication(String medicine) {
        health.addMedications(medicine);
    }

    public void removeMedication(String medicine) {
        health.removeMedications(medicine);
    }

    @Override
    public String toString() {
        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " +
                super.getPhoneNumber() + " " + object;
    }
}