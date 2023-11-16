package com.solvd.insurancecompany.company;

import com.solvd.insurancecompany.insurances.*;
import com.solvd.insurancecompany.people.*;
import com.solvd.insurancecompany.exceptions.*;
import com.solvd.insurancecompany.objects.*;
import java.util.*;

public class InsuranceCompany implements ICompanyManage, IIssue, IRequest {

    private String name;
    private LinkedList<Employee> employees = new LinkedList<>();
    private CustomLinkedList<Customer> customers = new CustomLinkedList<>();
    private Map<String, List<Insurance>> issuedInsurancesMap = new HashMap<>();
    private Queue<InsuranceRequest> requests = new ArrayDeque<>();
    private static int insuranceCount;

    public InsuranceCompany(String name) {
        this.name = name;
    }

    @Override
    public Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, Date issueDate, Date endDate) throws InvalidPriceException, InvalidM2Exception, InvalidInsureObjectException {
        if (request.getCustomer().getInsureObject() instanceof Vehicle) {
            if (((Vehicle) request.getCustomer().getInsureObject()).getPrice() < IInsuranceObjectParameter.INVALID_VEHICLE_PRICE) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + IInsuranceObjectParameter.INVALID_VEHICLE_PRICE);
            }
            VehicleInsurance insurance = new VehicleInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate, (Vehicle) request.getCustomer().getInsureObject());
            insuranceCount++;
            return insurance;
        } else if (request.getCustomer().getInsureObject() instanceof Home) {
            if (((Home) request.getCustomer().getInsureObject()).getPrice() < IInsuranceObjectParameter.INVALID_HOME_PRICE) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + IInsuranceObjectParameter.INVALID_HOME_PRICE);
            }
            if (((Home) request.getCustomer().getInsureObject()).getM2() < IInsuranceObjectParameter.INVALID_HOME_M2) {
                throw new InvalidM2Exception("Wrong M2. Please use greater than " + IInsuranceObjectParameter.INVALID_HOME_M2);
            }
            HomeInsurance insurance = new HomeInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate, (Home) request.getCustomer().getInsureObject());
            insuranceCount++;
            return insurance;
        } else if (request.getCustomer().getHealth() instanceof Health) {
            HealthInsurance insurance = new HealthInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate);
            insuranceCount++;
            return insurance;
        }
        throw new InvalidInsureObjectException("Unsupported Insure Object");
    }

    @Override
    public InsuranceRequest requestInsurance(Customer customer) throws InvalidPersonException {
        if (customer == null) {
            throw new InvalidPersonException("Invalid person for Insurance request.");
        }
        InsuranceRequest request = new InsuranceRequest(customer);
        addRequest(request);
        return request;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.insert(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public CustomLinkedList<Customer> getCustomers() {
        return customers;
    }

    public String getCustomersList() {
        return customers.printList();
    }

    @Override
    public void addInsuranceList(String key, List<Insurance> insurances) {
        issuedInsurancesMap.put(key, insurances);
    }

    @Override
    public void removeInsuranceList(String key) {
        issuedInsurancesMap.remove(key);
    }

    public Map<String, List<Insurance>> getIssuedInsurances() {
        return issuedInsurancesMap;
    }

    @Override
    public void addRequest(InsuranceRequest request) {
        requests.offer(request);
    }

    public Queue<InsuranceRequest> getRequests() {
        return requests;
    }
}
