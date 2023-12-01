package com.solvd.insurancecompany.objects;

import com.solvd.insurancecompany.exceptions.InsuranceObjectParameter;

import java.util.Objects;

public class Vehicle extends InsureObject {

    private final double price;
    private final String fuel;
    private final int year;
    private final ObjectType objectType;

    public Vehicle(String type, double price, String fuel, int year) {
        super(type);
        objectType = ObjectType.VEHICLE;
        this.price = price;
        this.fuel = fuel;
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public String insuranceObjectLevel() {
        if (price > InsuranceObjectParameter.BASE_VEHICLE_PRICE.getValue() && year > InsuranceObjectParameter.BASE_VEHICLE_LEVEL_YEAR.getValue()) {
            return LuxuryLevel.HIGH_LEVEL.getDescription();
        } else if (price > InsuranceObjectParameter.BASE_VEHICLE_PRICE.getValue() || year > InsuranceObjectParameter.BASE_VEHICLE_LEVEL_YEAR.getValue()) {
            return LuxuryLevel.MEDIUM_LEVEL.getDescription();
        } else {
            return LuxuryLevel.LOW_LEVEL.getDescription();
        }
    }

    @Override
    public String getObjectName() { return objectName; }

    @Override
    public String toString() {
        return "Vehicle: " + "id (" + objectId + ") " + objectName + " " + price + " " + fuel + " " + year;
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
        return Objects.equals(objectName, self.objectName) && Objects.equals(price, self.price)
                && Objects.equals(fuel, self.fuel) && Objects.equals(year, self.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectName, price, fuel, year);
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }
}