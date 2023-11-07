package insurances;

import company.InsuranceCompany;
import people.Customer;
import people.Employee;

public class InsuranceRequest {

    private Customer customer;

    private InsuranceCompany company;

    private Object insureObject;

    public InsuranceRequest(Customer customer, InsuranceCompany company, Object insureObject) {
        this.customer = customer;
        this.company = company;
        this.insureObject = insureObject;
    }

    @Override
    public String toString() {
        return "Customer: " + customer + " Company: " + company + " Object for insure " + insureObject;
    }
}
