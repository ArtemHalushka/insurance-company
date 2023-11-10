package insurances;

import exceptions.InvalidPersonException;
import people.Customer;

public interface IRequest {

    InsuranceRequest requestInsurance(Customer customer) throws InvalidPersonException;
}
