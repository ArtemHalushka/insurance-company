package com.solvd.insurancecompany.objects;

import com.solvd.insurancecompany.exceptions.InsuranceObjectParameter;

import java.util.Objects;
public class Home extends InsureObject {

    private final double price;
    private final double m2;
    private final ObjectType objectType;

    public Home(String type, double price, double m2) {
        super(type);
        objectType = ObjectType.HOME;
        this.price = price;
        this.m2 = m2;
    }

    public double getPrice() {
        return price;
    }

    public double getM2() {
        return m2;
    }

    public String insuranceObjectLevel() {
        if (price > InsuranceObjectParameter.BASE_HOME_PRICE.getValue() && m2 > InsuranceObjectParameter.BASE_HOME_PRICE.getValue()) {
            return LuxuryLevel.HIGH_LEVEL.getDescription();
        }else if (price > InsuranceObjectParameter.BASE_HOME_PRICE.getValue() || m2 > InsuranceObjectParameter.BASE_HOME_M2_AREA.getValue()) {
            return LuxuryLevel.MEDIUM_LEVEL.getDescription();
        } else {
            return LuxuryLevel.LOW_LEVEL.getDescription();
        }
    }

    @Override
    public String getObjectName() { return objectName; }

    @Override
    public String toString() {
        return "Home: " + "id (" + objectId + ") " + objectName + " " + price + " " + m2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Home self = (Home) object;
        return Objects.equals(objectName, self.objectName) && Objects.equals(price, self.price) && Objects.equals(m2, self.m2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectName, price, m2);
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }
}