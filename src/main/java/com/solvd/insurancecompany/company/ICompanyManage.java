package com.solvd.insurancecompany.company;

import com.solvd.insurancecompany.insurances.Insurance;
import com.solvd.insurancecompany.insurances.InsuranceRequest;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;

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