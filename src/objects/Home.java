package objects;

public class Home {

    private String type;
    private double price;
    private int m2;

    public Home(String type, double price, int m2) {
        this.type = type;
        this.price = price;
        this.m2 = m2;
    }

    @Override
    public String toString() {
        return "Home" + " " + type + " " + price + " " + m2;
    }
}
