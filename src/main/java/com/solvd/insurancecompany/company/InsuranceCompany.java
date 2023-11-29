package com.solvd.insurancecompany.company;

import com.solvd.insurancecompany.Main;
import com.solvd.insurancecompany.customlinkedlist.CustomLinkedList;
import com.solvd.insurancecompany.insurances.*;
import com.solvd.insurancecompany.people.*;
import com.solvd.insurancecompany.exceptions.*;
import com.solvd.insurancecompany.objects.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class InsuranceCompany implements ICompanyManage, IIssue, IRequest {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private String name;
    private LinkedList<Employee> employees = new LinkedList<>();
    private CustomLinkedList<Customer> customers = new CustomLinkedList<>();
    private Map<String, List<Insurance>> issuedInsurancesMap = new HashMap<>();
    private Queue<InsuranceRequest> requests = new ArrayDeque<>();
    private static int insuranceCount;

    public InsuranceCompany(String name) {
        this.name = name;
    }

    public static int getInsuranceCount() {
        return insuranceCount;
    }

    public CustomLinkedList<Customer> getCustomers() {
        return customers;
    }

    public String getCustomersList() {
        return customers.printList();
    }

    public Map<String, List<Insurance>> getIssuedInsurances() {
        return issuedInsurancesMap;
    }

    public Queue<InsuranceRequest> getRequests() {
        return requests;
    }

    public void printEmployees() {
        employees.forEach(employee -> LOGGER.info(employee.toString()));
    }

    public void printCustomers() {
        customers.forEach(customer -> LOGGER.info(customer.toString()));
    }

    public void findVehicleObject(String insureObjectName) {
        customers.forEach(customer -> {
            if (insureObjectName.equals(customer.getInsureObject().getType())) {
                LOGGER.info(customer.getInsureObject().toString());
            }
        });
    }

    public void findMinimalPriceForInsurance() {
        issuedInsurancesMap.forEach((key, insurances) -> {
            double minimalPrice = insurances.stream()
                    .mapToDouble(Insurance :: getFinalPrice)
                    .min()
                    .orElse(0.0);
            LOGGER.info("Minimal price of " + key + " is: " + minimalPrice);
        });
    }

    @Override
    public Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, Date issueDate, Date endDate) throws InvalidPriceException, InvalidM2Exception, InvalidInsureObjectException {
        if (request.getCustomer().getInsureObject() instanceof Vehicle) {
            if (((Vehicle) request.getCustomer().getInsureObject()).getPrice() < InsuranceObjectParameter.INVALID_VEHICLE_PRICE.getValue()) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + InsuranceObjectParameter.INVALID_VEHICLE_PRICE.getValue());
            }
            VehicleInsurance insurance = new VehicleInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate, (Vehicle) request.getCustomer().getInsureObject());
            insuranceCount++;
            return insurance;
        } else if (request.getCustomer().getInsureObject() instanceof Home) {
            if (((Home) request.getCustomer().getInsureObject()).getPrice() < InsuranceObjectParameter.INVALID_HOME_PRICE.getValue()) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + InsuranceObjectParameter.INVALID_HOME_PRICE.getValue());
            }
            if (((Home) request.getCustomer().getInsureObject()).getM2() < InsuranceObjectParameter.INVALID_HOME_M2.getValue()) {
                throw new InvalidM2Exception("Wrong M2. Please use greater than " + InsuranceObjectParameter.INVALID_HOME_M2.getValue());
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

    @Override
    public void addInsuranceList(String key, List<Insurance> insurances) {
        issuedInsurancesMap.put(key, insurances);
    }

    @Override
    public void removeInsuranceList(String key) {
        issuedInsurancesMap.remove(key);
    }

    @Override
    public void addRequest(InsuranceRequest request) {
        requests.offer(request);
    }
}

