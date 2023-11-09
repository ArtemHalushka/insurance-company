package people;

public class Employee extends Person {

    private String position;
    private int personId = (int) (Math.random() * 10001);


    public Employee(String name, String birthDate, String address, String phoneNumber, String position) {
        super(name, birthDate, address, phoneNumber);
        this.position = position;
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Person: " + "id (" + personId + ") " + super.getName() + " " + super.getBirthDate() + " " + super.getAddress() + " " + super.getPhoneNumber() + " " + position;
    }
}


