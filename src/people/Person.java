package people;

import java.util.Objects;

public abstract class Person {

    private String name;
    private String birthDate;
    private String address;
    private int phoneNumber;
    private static int insurancePersonId;

    public Person(String name, String birthDate, String address, int phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
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
