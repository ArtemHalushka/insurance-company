package company;

import insurances.Insurance;
import insurances.InsuranceRequest;
import objects.InsureObject;
import people.Customer;
import people.Employee;

public interface ICompanyManage {

    void addEmployee(String employeeName, Employee employee);
    void removeEmployee(String employeeName);
    void addCustomer(String employeeName, Customer customer);
    void removeCustomer(String customerName);
    void addInsurance(Insurance insurance);
    void removeInsurance(Insurance insurance);
    void addRequest(InsuranceRequest request);
    void removeInsurance(InsuranceRequest request);
}