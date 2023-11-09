package insurances;

import exceptions.InvalidM2Exception;
import exceptions.InvalidPriceException;
import people.Employee;

public interface IIssue {

    Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                             String endDate) throws InvalidPriceException, InvalidM2Exception;
}
