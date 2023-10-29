package objects;

public class Vehicle {
    private String type;
    private int price;
    private int fuel;
    private int year;

    public Vehicle(String type, int price, int fuel, int year) {
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.year = year;
    }
}