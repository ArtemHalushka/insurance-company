package calculators;

import objects.Health;
import objects.Home;
import objects.InsureObject;
import objects.Vehicle;

public class PriceCalculator {

    private final static double INSURANCE_COMPANY_COEFFICIENT = 10;
    private final static double HOME_PRICE_PERCENT = 0.1;
    private final static double VEHICLE_PRICE_PERCENT = 0.3;
    private final static double HEALTH_PRICE_PERCENT = 2;
    private final static double MINIMAL_HEALTH_PRICE = 10;

    public static double calculateInsurancePrice(InsureObject insureObject) {
        if (insureObject instanceof Vehicle) {
            return ((VEHICLE_PRICE_PERCENT / 100) * ((Vehicle) insureObject).getPrice() * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT);
        } else if (insureObject instanceof Home) {
            return ((HOME_PRICE_PERCENT / 100) * ((Home) insureObject).getPrice() * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT);
        } else if (insureObject instanceof Health) {
            if ((((Health) insureObject).getHealthDiseases().size()) == 0) {
                return MINIMAL_HEALTH_PRICE;
            }
            return ((HEALTH_PRICE_PERCENT / 100) * ((((Health) insureObject).getHealthDiseases().size()) * 300)) * PriceCalculator.INSURANCE_COMPANY_COEFFICIENT;
        }
        return 0;
    }
}