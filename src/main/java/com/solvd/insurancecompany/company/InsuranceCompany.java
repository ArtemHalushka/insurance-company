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
import java.util.stream.Collectors;

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

    public void findInsureObjectByName(String insureObjectName) {
        customers.forEach(customer -> {
            if (insureObjectName.equals(customer.getInsureObject().getObjectName())) {
                LOGGER.info(customer.getInsureObject().toString());
            }
        });
    }

    public List<Customer> findAllCustomerByName(String customerName) {
        List<Customer> filteredCustomers = new ArrayList<>();
        customers.forEach(customer -> {
            if (customerName.equals(customer.getName())) {
                filteredCustomers.add(customer);
            }
        });
        return filteredCustomers;
    }

    public List<Customer> findAllCustomerByAddress(String customerAddress) {
        List<Customer> filteredCustomers = new ArrayList<>();
        customers.forEach(customer -> {
            if (customerAddress.equals(customer.getAddress())) {
                filteredCustomers.add(customer);
            }
        });
        return filteredCustomers;
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

    public List<Employee> findAllEmployeesByName(String employeeName) {
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employeeName.equals(employee.getName()))
                .collect(Collectors.toList());
        return filteredEmployees;
    }

    public List<Employee> findAllEmployeesByAddress(String employeeAddress) {
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employeeAddress.equals(employee.getAddress()))
                .collect(Collectors.toList());
        return filteredEmployees;
    }

    public List<Employee> findAllEmployeeByPosition(String position) {
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> position.equals(employee.getPosition()))
                .collect(Collectors.toList());
        return filteredEmployees;
    }

    @Override
    public Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, Date issueDate, Date endDate) throws InvalidPriceException, InvalidM2Exception, InvalidInsureObjectException {
        if (request.getCustomer().getInsureObject() == null) {
            if (request.getCustomer().getHealth().getObjectType() == ObjectType.HEALTH) {
                HealthInsurance insurance = new HealthInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate);
                insuranceCount++;
                return insurance;
            }
        } else if (request.getCustomer().getInsureObject().getObjectType() == ObjectType.VEHICLE) {
            if (((Vehicle) request.getCustomer().getInsureObject()).getPrice() < InsuranceObjectParameter.MIN_VEHICLE_PRICE.getValue()) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + InsuranceObjectParameter.MIN_VEHICLE_PRICE.getValue());
            }
            VehicleInsurance insurance = new VehicleInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate, (Vehicle) request.getCustomer().getInsureObject());
            insuranceCount++;
            return insurance;
        } else if (request.getCustomer().getInsureObject().getObjectType() == ObjectType.HOME) {
            if (((Home) request.getCustomer().getInsureObject()).getPrice() < InsuranceObjectParameter.MIN_HOME_PRICE.getValue()) {
                throw new InvalidPriceException("Wrong price. Please use greater than " + InsuranceObjectParameter.MIN_HOME_PRICE.getValue());
            }
            if (((Home) request.getCustomer().getInsureObject()).getM2() < InsuranceObjectParameter.MIN_HOME_M2.getValue()) {
                throw new InvalidM2Exception("Wrong M2. Please use greater than " + InsuranceObjectParameter.MIN_HOME_M2.getValue());
            }
            HomeInsurance insurance = new HomeInsurance(insuranceName, employee, request.getCustomer(), issueDate, endDate, (Home) request.getCustomer().getInsureObject());
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

