package insurances;

import people.Customer;
import objects.Home;
import objects.Vehicle;
import people.Employee;

public interface IIssue {
    HomeInsurance issueHomeInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                                    String endDate);

    VehicleInsurance issueVehicleInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                             String endDate);

    HealthInsurance issueHealthInsurance(InsuranceRequest request, Employee employee, String insuranceName, String issueDate,
                             String endDate);


}
