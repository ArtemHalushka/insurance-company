package company;

import insurances.Insurance;
import insurances.InsuranceRequest;
import people.*;

import java.util.ArrayList;

public class InsuranceCompany implements ICompanyManage {

    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers;
    private ArrayList<Insurance> issuedInsurances;
    private ArrayList<InsuranceRequest> requests;
    private static int insuranceCount;

    public InsuranceCompany(String name) {
        this.name = name;
        employees = new ArrayList<Employee>();
        customers = new ArrayList<Customer>();
        issuedInsurances = new ArrayList<Insurance>();
        requests = new ArrayList<InsuranceRequest>();
    }

    public static void countInsurance() {
        insuranceCount++;
    }

    // Employees ArrayList
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Customers ArrayList
    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // IssuedInsurance ArrayList
    @Override
    public void addInsurance(Insurance insurance) {
        issuedInsurances.add(insurance);
    }

    @Override
    public void removeInsurance(Insurance insurance) {
        issuedInsurances.remove(insurance);
    }

    public ArrayList<Insurance> getIssuedInsurances() {
        return issuedInsurances;
    }

    @Override
    public void addRequest(InsuranceRequest request) {
        requests.add(request);
    }

    @Override
    public void removeInsurance(InsuranceRequest request) {requests.remove(request);
    }

    public ArrayList<InsuranceRequest> getRequests() {
        return requests;
    }
}
