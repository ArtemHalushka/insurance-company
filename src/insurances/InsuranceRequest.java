package insurances;

import company.InsuranceCompany;
import people.Customer;

public class InsuranceRequest {

    private Customer customer;

    private InsuranceCompany company;

    public InsuranceRequest(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Customer: " + customer + " Object for insure " + customer.getInsureObject();
    }
}
