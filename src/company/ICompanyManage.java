package company;

import insurances.Insurance;
import insurances.InsuranceRequest;
import objects.InsureObject;
import people.Customer;
import people.Employee;

public interface ICompanyManage {

    void addEmployee(Employee employee);
    void removeEmployee(Employee employee);
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    void addInsurance(Insurance insurance);
    void removeInsurance(Insurance insurance);
    void addRequest(InsuranceRequest request);
    void removeRequest(InsuranceRequest request);
}