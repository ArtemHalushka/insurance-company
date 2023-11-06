package insurancePrice;

import objects.Vehicle;

public class VehiclePrice implements IPrice {

    private final static double VEHICLE_PRICE_PERCENT = 0.3;
    private double fullPrice;

    @Override
    public <T> double countPrice(T object) {
        if (object instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) object;
            double price = vehicle.getPrice();
            return fullPrice = ((VEHICLE_PRICE_PERCENT / 100) * price) * IPrice.INSURANCE_COMPANY_COEFFICIENT;
        } else {
            System.out.println("Wrong object, you should use Vehicle object for that method");
            fullPrice = 0;
        }
        return 0;
    }
}

