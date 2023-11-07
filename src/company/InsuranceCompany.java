package company;

import insurances.*;
import objects.Home;
import objects.Vehicle;
import people.*;

import java.util.ArrayList;

public class InsuranceCompany implements ICompanyManage, IIssue {

    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Insurance> issuedInsurances = new ArrayList<>();
    private ArrayList<InsuranceRequest> requests = new ArrayList<>();
    private static int insuranceCount;

    public InsuranceCompany(String name) {
        this.name = name;
    }

    @Override
    public VehicleInsurance issueVehicleInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                                           String endDate) {

        VehicleInsurance insurance = new VehicleInsurance(insuranceName, employee, request.getCustomer(),
                issueDate, endDate, (Vehicle) request.getCustomer().getInsureObject());
        InsuranceCompany.countInsurance();
        return insurance;
    }

    @Override
    public HealthInsurance issueHealthInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                                          String endDate) {

        HealthInsurance insurance = new HealthInsurance(insuranceName, employee, request.getCustomer(),
                issueDate, endDate);
        InsuranceCompany.countInsurance();
        return insurance;
    }

    @Override
    public HomeInsurance issueHomeInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                                                String endDate) {

        HomeInsurance insurance = new HomeInsurance(insuranceName, employee, request.getCustomer(),
                issueDate, endDate, (Home) request.getCustomer().getInsureObject());
        InsuranceCompany.countInsurance();
        return insurance;
    }

    public static void countInsurance() {
        insuranceCount++;
    }

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
