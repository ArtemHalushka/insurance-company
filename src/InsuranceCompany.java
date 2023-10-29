import Insurances.Insurance;
import people.*;

public class InsuranceCompany {
    private String name;
    private Employee[] employees;
    private Customer[] customers;
    private Insurance[] issuedInsurances;

    public InsuranceCompany(String name, Employee[] employees, Customer[] customers, Insurance[] issuedInsurances) {
        this.name = name;
        this.employees = employees;
        this.customers = customers;
        this.issuedInsurances = issuedInsurances;
    }
}
