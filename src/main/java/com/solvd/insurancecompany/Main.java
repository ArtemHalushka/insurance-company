package com.solvd.insurancecompany;

import com.solvd.insurancecompany.company.InsuranceCompany;
import com.solvd.insurancecompany.connectionpool.ConnectionPool;
import com.solvd.insurancecompany.exceptions.*;
import com.solvd.insurancecompany.filereader.CustomFileReader;
import com.solvd.insurancecompany.insurances.*;
import com.solvd.insurancecompany.objects.HealthDisease;
import com.solvd.insurancecompany.objects.Medication;
import com.solvd.insurancecompany.people.Customer;
import com.solvd.insurancecompany.people.Employee;
import com.solvd.insurancecompany.threads.CustomThread;
import com.solvd.insurancecompany.threads.RunnableThread;
import org.apache.logging.log4j.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        InsuranceCompany insuranceCompany = new InsuranceCompany("Reico");
        boolean michaelIsSmoker = true;

        try {
            Employee jim = new Employee("Jim Turner", dateFormat.parse("10-10-1999"), "United states", "919883992", "Lead");
            insuranceCompany.addEmployee(jim);
            Employee sam = new Employee("Sam Smith", dateFormat.parse("3-05-1989"), "Canada", "992039203", "Clerk");
            insuranceCompany.addEmployee(sam);
            Class<?> customerClass = Class.forName("com.solvd.insurancecompany.people.Customer");
            Constructor<?> healthCustomerConstructor = customerClass.getDeclaredConstructor(String.class, Date.class, String.class, String.class, String.class, boolean.class);
            Constructor<?> vehicleCustomerConstructor = customerClass.getDeclaredConstructor(String.class, Date.class, String.class, String.class, String.class, double.class, String.class, int.class);
            Constructor<?> homeCustomerConstructor = customerClass.getDeclaredConstructor(String.class, Date.class, String.class, String.class, String.class, double.class, int.class);
            Object lena = vehicleCustomerConstructor.newInstance("Lena Lorens", dateFormat.parse("22-06-2000"), "United States", "9901243", "5 Series", 15000, "Gas", 2007);
            Object tim = vehicleCustomerConstructor.newInstance("Tim Lorens", dateFormat.parse("22-06-2000"), "United States", "9901243", "Mustang", 15000, "Gas", 2007);
            Object jina = homeCustomerConstructor.newInstance("Jina Lopez", dateFormat.parse("27-09-1978"), "Canada", "98492034", "5 Bedroom", 20000, 1333);
            Object michael = healthCustomerConstructor.newInstance("Michael Flint", dateFormat.parse("11-12-2001"), "United states",
                    "8839021", "Michael Health", michaelIsSmoker);
            Method addHealthDisease = customerClass.getMethod("addHealthDisease", HealthDisease.class);
            Method addMedication = customerClass.getMethod("addMedication", Medication.class);
            addMedication.invoke(michael, Medication.MEZIM);
            addHealthDisease.invoke(michael, HealthDisease.DIABETES);
            addHealthDisease.invoke(michael, HealthDisease.HIGH_BLOOD_PRESSURE);
            InsuranceRequest michaelRequest = insuranceCompany.requestInsurance((Customer) michael);
            insuranceCompany.addCustomer((Customer) michael);
            insuranceCompany.addCustomer((Customer) lena);
            insuranceCompany.addCustomer((Customer) tim);
            InsuranceRequest timRequest = insuranceCompany.requestInsurance((Customer) tim);
            InsuranceRequest lenaRequest = insuranceCompany.requestInsurance((Customer) lena);
            insuranceCompany.addCustomer((Customer) jina);
            InsuranceRequest jinaRequest = insuranceCompany.requestInsurance((Customer) jina);

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

            Thread runnableThreadFileReader = new Thread(new RunnableThread("input1.txt"));
            CustomThread customThreadFileReader = new CustomThread("input2.txt");
            runnableThreadFileReader.start();
            customThreadFileReader.start();
            ConnectionPool connectionPool = new ConnectionPool("input.txt");
            CustomThread thread1 = connectionPool.getConnection("input.txt");
            thread1.start();
            connectionPool.releaseConnection(thread1);
            CustomThread thread2 = connectionPool.getConnection("input.txt");
            thread2.start();
            connectionPool.releaseConnection(thread2);
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> CustomFileReader.readFile("input.txt"));
            completableFuture.join();

        } catch (InvalidPriceException | InvalidM2Exception | InvalidInsureObjectException | StringLengthException |
                 ParseException | InvalidPersonException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error("Exception:", e);
        }
    }
}
