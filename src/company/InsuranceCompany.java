package company;

import insurances.*;
import objects.*;
import people.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.Date;

public class InsuranceCompany implements ICompanyManage, IIssue, IRequest {

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
    public Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, Date issueDate,
                                    Date endDate) throws InvalidPriceException, InvalidM2Exception, InvalidInsureObjectException {
        if (request.getCustomer().getInsureObject() instanceof Vehicle) {
            if (((Vehicle) request.getCustomer().getInsureObject()).getPrice() < IInsuranceObjectParameter.INVALID_VEHICLE_PRICE) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + IInsuranceObjectParameter.INVALID_VEHICLE_PRICE);
            }
            VehicleInsurance insurance = new VehicleInsurance(insuranceName, employee, request.getCustomer(),
                    issueDate, endDate, (Vehicle) request.getCustomer().getInsureObject());
            insuranceCount++;
            return insurance;
        } else if (request.getCustomer().getInsureObject() instanceof Home) {
                if (((Home) request.getCustomer().getInsureObject()).getPrice() < IInsuranceObjectParameter.INVALID_HOME_PRICE) {
                    throw new InvalidPriceException("Wrong price. Please use greater than " + IInsuranceObjectParameter.INVALID_HOME_PRICE);
                }
                if (((Home) request.getCustomer().getInsureObject()).getM2() < IInsuranceObjectParameter.INVALID_HOME_M2) {
                    throw new InvalidM2Exception("Wrong price. Please use greater than " + IInsuranceObjectParameter.INVALID_HOME_M2);
                }
                HomeInsurance insurance = new HomeInsurance(insuranceName, employee, request.getCustomer(),
                        issueDate, endDate, (Home) request.getCustomer().getInsureObject());
                insuranceCount++;
                return insurance;
        } else if (request.getCustomer().getInsureObject() instanceof Health) {
            HealthInsurance insurance = new HealthInsurance(insuranceName, employee, request.getCustomer(),
                    issueDate, endDate);
            insuranceCount++;
            return insurance;
        }
        throw new InvalidInsureObjectException("Unsupported Insure Object");
    }

    @Override
    public InsuranceRequest requestInsurance(Customer customer) {
        InsuranceRequest request = new InsuranceRequest(customer);
        addRequest(request);
        return request;
    }

    public static void increaseInsuranceCount() {
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
    public void removeInsurance(InsuranceRequest request) {
        requests.remove(request);
    }

    public ArrayList<InsuranceRequest> getRequests() {
        return requests;
    }
}