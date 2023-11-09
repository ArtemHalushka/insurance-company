package insurances;

import people.Employee;

public interface IIssue {

    Insurance issueInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                             String endDate);
}
