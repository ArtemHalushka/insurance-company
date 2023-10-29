package people;

import Insurances.Insurance;

public class Customer extends Person {
    private Insurance insuranceType;

    public Customer(String name,
            String birthDate,
            String address,
            int phoneNumber) {
        super(name, birthDate, address, phoneNumber);
        this.insuranceType = insuranceType;
    }
}
