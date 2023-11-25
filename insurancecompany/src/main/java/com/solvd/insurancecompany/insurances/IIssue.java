package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.people.Employee;
import com.solvd.insurancecompany.exceptions.*;

import java.util.Date;

public interface IIssue {

    Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, Date issueDate,
                             Date endDate) throws InvalidPriceException, InvalidM2Exception, InvalidInsureObjectException;
}
