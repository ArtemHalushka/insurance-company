package objects;

import java.util.Objects;

public class Vehicle {

    private final String type;
    private final double price;
    private final String fuel;
    private final int year;
    private static int objectId = 1;

    public Vehicle(String type, double price, String fuel, int year) {
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle: " + "id (" + objectId + ") " + type + " " + price + " " + fuel + " " + year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Vehicle self = (Vehicle) object;

        return Objects.equals(type, self.type) && Objects.equals(price, self.price)
                && Objects.equals(fuel, self.fuel) && Objects.equals(year, self.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, fuel, year);
    }
}