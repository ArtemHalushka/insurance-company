package calculators;

import objects.Home;
import objects.Vehicle;

public class PriceCalculator {
    private final static double INSURANCE_COMPANY_COEFFICIENT = 10;
    private final static double HOME_PRICE_PERCENT = 0.1;
    private final static double VEHICLE_PRICE_PERCENT = 0.3;
    private final static double HEALTH_PRICE_PERCENT = 2;


    public static double calculateVehiclePrice(Vehicle vehicle) {
        double price = object.getPrice();
        double fullPrice;
        return fullPrice = ((VEHICLE_PRICE_PERCENT / 100) * price) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
    }

    public static double calculateHomePrice(Home home) {
        double price = object.getPrice();
        double fullPrice;
        return fullPrice = ((HOME_PRICE_PERCENT / 100) * price) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
    }

    public static double countHealthPrice(String[] object) {
        int count = ((String[]) object).length;
        if (count == 0) {
            return 10;
        }
        double fullPrice;
        return fullPrice = ((HEALTH_PRICE_PERCENT / 100) * (count * 300)) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
    }


}
