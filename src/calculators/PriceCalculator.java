package calculators;

import objects.Home;
import objects.Vehicle;

public class PriceCalculator {

    private final static double INSURANCE_COMPANY_COEFFICIENT = 10;
    private final static double HOME_PRICE_PERCENT = 0.1;
    private final static double VEHICLE_PRICE_PERCENT = 0.3;
    private final static double HEALTH_PRICE_PERCENT = 2;


    public static double calculateVehiclePrice(Vehicle vehicle) {
        double price = vehicle.getPrice();
        return ((VEHICLE_PRICE_PERCENT / 100) * price) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
    }

    public static double calculateHomePrice(Home home) {
        double price = home.getPrice();
        return ((HOME_PRICE_PERCENT / 100) * price) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
    }

    public static double calculateHealthPrice(String[] healthDiseases) {
        int count = ((String[]) healthDiseases).length;
        if (count == 0) {
            return 10;
        }
        return ((HEALTH_PRICE_PERCENT / 100) * (count * 300)) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
    }
}
