package insurancePrice;

public interface IPrice {
    double INSURANCE_COMPANY_COEFFICIENT = 10;
    <T> double countPrice(T object);
}
