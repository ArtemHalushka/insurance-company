package objects;

import java.util.Objects;

public class Home implements IPrioritize {

    private final String type;
    private final double price;
    private final int m2;
    private static int objectId = 1;

    public Home(String type, double price, int m2) {
        this.type = type;
        this.price = price;
        this.m2 = m2;
    }

    @Override
    public String prioritizeInsuranceObject() {
        if (this.price > 59000 && this.m2 > 30) {
            return "High priority";
        }

        if (this.price > 59000 || this.m2 > 30) {
            return "Medium priority";
        } else return "Low priority";
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
