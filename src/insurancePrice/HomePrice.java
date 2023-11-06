package insurancePrice;

import objects.Home;

public class HomePrice implements IPrice {

    private final static double HOME_PRICE_PERCENT = 0.1;
    @Override
    public <T> double countPrice(T object) {
        if (object instanceof Home) {
            Home home = (Home) object;
            double price = home.getPrice();
            double fullPrice;
            return fullPrice = ((HOME_PRICE_PERCENT / 100) * price) * IPrice.INSURANCE_COMPANY_COEFFICIENT;

        } else {
            System.out.println("Wrong object, you should use Home object for that method");
        }
        return 0;
    }
}
