package com.solvd.insurancecompany.objects;

import java.util.Objects;
public class Home extends InsureObject {

    private final double price;
    private final double m2;

    public Home(String type, double price, double m2) {
        super(type);
        this.type = type;
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
        if (price > Price.HOME_PRICE.getValue() && m2 > Area.HOME_M2_AREA.getValue()) {
            return Level.HIGH_LEVEL.getDescription();
        }else if (price > Price.HOME_PRICE.getValue() || m2 > Area.HOME_M2_AREA.getValue()) {
            return Level.MEDIUM_LEVEL.getDescription();
        } else {
            return Level.LOW_LEVEL.getDescription();
        }
    }

    @Override
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Home: " + "id (" + objectId + ") " + type + " " + price + " " + m2;
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
        return Objects.equals(type, self.type) && Objects.equals(price, self.price) && Objects.equals(m2, self.m2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, m2);
    }
}