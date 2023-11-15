package company;

import insurances.Insurance;
import insurances.InsuranceRequest;
import objects.InsureObject;
import people.Customer;
import people.Employee;

import java.util.List;

public interface ICompanyManage {

    void addEmployee(Employee employee);
    void removeEmployee(Employee employee);
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    void addInsuranceList(String key, List<Insurance> insurances);
    void removeInsuranceList(String key);
    void addRequest(InsuranceRequest request);
}