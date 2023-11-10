package insurances;

import exceptions.*;
import people.Employee;

import java.util.Date;

public interface IIssue {

    Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, Date issueDate,
                             Date endDate) throws InvalidPriceException, InvalidM2Exception, InvalidInsureObjectException;
}
