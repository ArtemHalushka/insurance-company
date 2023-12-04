package com.solvd.insurancecompany.people;

import com.solvd.insurancecompany.exceptions.StringLengthException;

import java.util.Date;

public class Employee extends Person {

    private String position;

    public Employee(String name, Date birthDate, String address, String phoneNumber, String position) throws StringLengthException {
        super(name, birthDate, address, phoneNumber);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " + super.getPhoneNumber() + " " + position;
    }
}


