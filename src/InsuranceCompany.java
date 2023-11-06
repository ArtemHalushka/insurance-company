import insurances.Insurance;
import people.*;

import java.util.ArrayList;

public class InsuranceCompany {

    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers;
    private ArrayList<Insurance> issuedInsurances;
    private static int insuranceCount;

    public InsuranceCompany(String name) {
        this.name = name;
        employees = new ArrayList<Employee>();
        customers = new ArrayList<Customer>();
        issuedInsurances = new ArrayList<Insurance>();
    }

    public void addInsurance() {
        insuranceCount++;
    }

    // Employees ArrayList
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Customers ArrayList
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // IssuedInsurance ArrayList
    public void addInsurance(Insurance insurance) {
        issuedInsurances.add(insurance);
    }

    public void removeInsurance(Insurance insurance) {
        issuedInsurances.remove(insurance);
    }

    public ArrayList<Insurance> getIssuedInsurances() {
        return issuedInsurances;
    }
}
