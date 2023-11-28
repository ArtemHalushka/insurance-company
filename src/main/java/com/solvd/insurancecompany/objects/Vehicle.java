package com.solvd.insurancecompany.objects;

import java.util.Objects;

public class Vehicle extends InsureObject {

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

    public String insuranceObjectLevel() {
        if (price > Price.VEHICLE_PRICE.getValue() && year > Year.VEHICLE_LEVEL_YEAR.getValue()) {
            return Level.HIGH_LEVEL.getDescription();
        } else if (price > Price.VEHICLE_PRICE.getValue() || year > Year.VEHICLE_LEVEL_YEAR.getValue()) {
            return Level.MEDIUM_LEVEL.getDescription();
        } else {
            return Level.LOW_LEVEL.getDescription();
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