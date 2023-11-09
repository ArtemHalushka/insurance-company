package objects;

import java.util.Objects;

public class Home extends InsureObject implements ILevel {

    private final String type;
    private final double price;
    private final int m2;

    public Home(String type, double price, int m2) {
        super();
        this.type = type;
        this.price = price;
        this.m2 = m2;
        this.objectId = objectId;
    }

    @Override
    public String insuranceObjectLevel() {
        if (price > HOME_LEVEL_PRICE && m2 > HOME_LEVEL_M2) {
            return HIGH_LEVEL;
        }

        if (price > HOME_LEVEL_PRICE || m2 > HOME_LEVEL_M2) {
            return MEDIUM_LEVEL;
        } else {
            return LOW_LEVEL;
        }
    }

    public double getPrice() {
        return price;
    }

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