package com.solvd.insurancecompany;

import com.solvd.insurancecompany.company.InsuranceCompany;
import com.solvd.insurancecompany.exceptions.*;
import com.solvd.insurancecompany.insurances.*;
import com.solvd.insurancecompany.objects.HealthDisease;
import com.solvd.insurancecompany.objects.Medication;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;
import com.solvd.insurancecompany.util.Printer;
import org.apache.logging.log4j.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        InsuranceCompany insuranceCompany = new InsuranceCompany("Reico");
        boolean michaelIsSmoker = true;

        try {
            Employee jim = new Employee("Jim Turner", dateFormat.parse("10-10-1999"), "United states", "919883992", "Lead");
            insuranceCompany.addEmployee(jim);
            Employee sam = new Employee("Sam Smith", dateFormat.parse("3-05-1989"), "Canada", "992039203", "Clerk");
            insuranceCompany.addEmployee(sam);
            Customer michael = new Customer("Michael Flint", dateFormat.parse("11-12-2001"), "United states",
                    "8839021","Michael Health", michaelIsSmoker);
            michael.addHealthDisease(HealthDisease.DIABETES);
            michael.addHealthDisease(HealthDisease.HIGH_BLOOD_PRESSURE);
            michael.addMedication(Medication.MEZIM);
            InsuranceRequest michaelRequest = insuranceCompany.requestInsurance(michael);
            insuranceCompany.addCustomer(michael);
            Customer lena = new Customer("Lena Lorens", dateFormat.parse("22-06-2000"), "United States", "9901243", "5 Series", 15000, "Gas", 2007);
            insuranceCompany.addCustomer(lena);
            Customer tim = new Customer("Tim Lorens", dateFormat.parse("22-06-2000"), "United States", "9901243", "Mustang", 15000, "Gas", 2007);
            insuranceCompany.addCustomer(tim);
            InsuranceRequest timRequest = insuranceCompany.requestInsurance(tim);
            InsuranceRequest lenaRequest = insuranceCompany.requestInsurance(lena);
            Customer jina = new Customer("Jina Lopez", dateFormat.parse("27-09-1978"), "Canada", "98492034", "5 Bedroom", 20000, 1333);
            insuranceCompany.addCustomer(jina);
            InsuranceRequest jinaRequest = insuranceCompany.requestInsurance(jina);

            Insurance michaelInsurance = insuranceCompany.issueInsurance(michaelRequest, sam, "health", dateFormat.parse("09-01-2023"), dateFormat.parse("09-01-2025"));
            Insurance lenaVehicleInsurance = insuranceCompany.issueInsurance(lenaRequest, jim, "vehicle", dateFormat.parse("09-01-2023"), dateFormat.parse("09-01-2025"));
            Insurance jinaHomeInsurance = insuranceCompany.issueInsurance(jinaRequest, jim, "home", dateFormat.parse("09-01-2023"), dateFormat.parse("09-01-2025"));
            Insurance timVehicleInsurance = insuranceCompany.issueInsurance(timRequest, sam, "vehicle", dateFormat.parse("09-01-2023"), dateFormat.parse("09-01-2025"));

            List<Insurance> vehicleInsuranceList = new ArrayList<>();
            vehicleInsuranceList.add(lenaVehicleInsurance);
            vehicleInsuranceList.add(timVehicleInsurance);
            List<Insurance> healthInsuranceList = new ArrayList<>();
            healthInsuranceList.add(michaelInsurance);
            List<Insurance> homeInsuranceList = new ArrayList<>();
            homeInsuranceList.add(jinaHomeInsurance);
            insuranceCompany.addInsuranceList("VehicleInsurances", vehicleInsuranceList);
            insuranceCompany.addInsuranceList("HomeInsurances", homeInsuranceList);
            insuranceCompany.addInsuranceList("HealthInsurances", healthInsuranceList);
            LOGGER.info(insuranceCompany.getCustomersList());
        } catch (InvalidPriceException | InvalidM2Exception | InvalidInsureObjectException | StringLengthException |
                 ParseException | InvalidPersonException e) {
            LOGGER.error("Exception:", e);
        }
    }
}
