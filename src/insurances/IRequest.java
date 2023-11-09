package insurances;

import company.InsuranceCompany;
import objects.InsureObject;
import people.Customer;

public interface IRequest {

    InsuranceRequest requestInsurance(Customer customer);

}
