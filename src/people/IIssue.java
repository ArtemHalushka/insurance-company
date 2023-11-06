package people;

import insurances.HealthInsurance;
import insurances.HomeInsurance;
import insurances.VehicleInsurance;
import objects.Home;
import objects.Vehicle;

public interface IIssue {
    VehicleInsurance issueVehicleInsurance(Customer customer, String insuranceName, String issueDate,
                                           String endDate, Vehicle vehicle);

    HealthInsurance issueHealthInsurance(Customer customer, String insuranceName, String issueDate, String endDate,
                                         String[] healthDiseases, Boolean smoker, String[] medications);

    HomeInsurance issueHomeInsurance(Customer customer, String insuranceName,
                                     String issueDate, String endDate, Home home);
}
