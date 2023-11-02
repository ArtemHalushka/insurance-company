package people;

public class Person {

    private String name;
    private String birthDate;
    private String address;
    private int phoneNumber;

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
}
