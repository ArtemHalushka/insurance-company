package com.solvd.insurancecompany.objects;

import java.util.Objects;

public class Vehicle extends InsureObject implements ILevel {

    private final String type;
    private final double price;
    private final String fuel;
    private final int year;

    public Vehicle(String type, double price, String fuel, int year) {
        super();
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String insuranceObjectLevel() {
        if (price > VEHICLE_LEVEL_PRICE && year > VEHICLE_LEVEL_YEAR) {
            return HIGH_LEVEL;
        } else if (price > VEHICLE_LEVEL_PRICE || year > VEHICLE_LEVEL_YEAR) {
            return MEDIUM_LEVEL;
        } else {
            return LOW_LEVEL;
        }
    }

    @Override
    public String toString() {
        return "Vehicle: " + "id (" + objectId + ") " + type + " " + price + " " + fuel + " " + year;
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