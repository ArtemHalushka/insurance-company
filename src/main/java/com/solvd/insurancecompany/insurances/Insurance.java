package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;
import java.util.Date;
import java.util.Objects;

abstract public class Insurance {

    private String insuranceName;
    private Employee issueEmployee;
    private Customer insuranceCustomer;
    private Date issueDate;
    private Date endDate;
    protected double finalPrice;

    public Insurance(String insuranceName, Employee issueEmployee, Customer insuranceCustomer,
                     Date issueDate, Date endDate) {
        this.insuranceName = insuranceName;
        this.issueEmployee = issueEmployee;
        this.insuranceCustomer = insuranceCustomer;
        this.issueDate = issueDate;
        this.endDate = endDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public double getFinalPrice() { return finalPrice; }

    public Employee getIssueEmployee() {
        return issueEmployee;
    }

    public Customer getInsuranceCustomer() {
        return insuranceCustomer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Insurance self = (Insurance) object;
        return Objects.equals(insuranceName, self.insuranceName) && Objects.equals(insuranceCustomer, self.insuranceCustomer)
                && Objects.equals(issueDate, self.issueDate) && Objects.equals(endDate, self.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insuranceName, insuranceCustomer, issueDate, endDate);
    }
}
