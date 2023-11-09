package insurances;

import people.Customer;

public interface IRequest {

    InsuranceRequest requestInsurance(Customer customer);
}
