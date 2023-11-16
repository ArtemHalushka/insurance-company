package com.solvd.insurancecompany.insurances;

import com.solvd.insurancecompany.exceptions.InvalidPersonException;
import com.solvd.insurancecompany.people.Customer;

public interface IRequest {

    InsuranceRequest requestInsurance(Customer customer) throws InvalidPersonException;
}
