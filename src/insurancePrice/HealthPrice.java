package insurancePrice;


public class HealthPrice implements IPrice {

    private final static double HEALTH_PRICE_PERCENT = 2;
    @Override
    public <T> double countPrice(T object) {
        if (object instanceof String[]) {
            int count = ((String[]) object).length;
            if (count == 0) {
                return 10;
            }
            double fullPrice;
            return fullPrice = ((HEALTH_PRICE_PERCENT / 100) * (count * 300)) * IPrice.INSURANCE_COMPANY_COEFFICIENT;

        } else {
            System.out.println("Wrong object, you should use HealthDiseases object for that method");
        }
        return 0;
    }
}
