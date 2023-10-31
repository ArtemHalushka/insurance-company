package objects;

public class Vehicle {

    private String type;
    private double price;
    private String fuel;
    private int year;

    public Vehicle(String type, double price, String fuel, int year) {
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.year = year;
    }
}