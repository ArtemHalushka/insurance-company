package com.solvd.insurancecompany.people;

import com.solvd.insurancecompany.exceptions.InsuranceObjectParameter;
import com.solvd.insurancecompany.exceptions.StringLengthException;

import java.util.Date;
import java.util.Objects;

public abstract class Person {

    private String name;
    private Date birthDate;
    private String address;
    private String phoneNumber;
    protected int personId = (int) (Math.random() * 10001);

    public Person(String name, Date birthDate, String address, String phoneNumber) throws StringLengthException {
        if (address.length() > InsuranceObjectParameter.INVALID_STRING_LENGTH) {
            throw new StringLengthException("Too long address");
        } 
        if (name.length() > InsuranceObjectParameter.INVALID_STRING_LENGTH) {
            throw new StringLengthException("Too long name");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Person self = (Person) object;
        return Objects.equals(birthDate, self.birthDate) && Objects.equals(name, self.name)
                && Objects.equals(address, self.address) && Objects.equals(phoneNumber, self.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, address, phoneNumber);
    }
}