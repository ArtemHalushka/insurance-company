import company.InsuranceCompany;
import insurances.*;
import objects.Health;
import people.Customer;
import people.Employee;
import util.Printer;

public class Main {

    public static void main(String[] args) {
        InsuranceCompany insuranceCompany = new InsuranceCompany("Reico");

        Employee jim = new Employee("Jim Turner", "10 October 1999", "United states", "919883992", "Lead");
        insuranceCompany.addEmployee(jim);

        Employee sam = new Employee("Sam Smith", "3 May 1989", "Canada", "992039203", "Clerk");
        insuranceCompany.addEmployee(sam);

        String[] michaelHealthDiseases = {"Diabetes", "High blood pressure"};
        String[] michaelMedications = {"Mezim"};
        boolean michaelIsSmoker = true;
        Customer michael = new Customer("Michael Flint", "11 December 2001", "United states",
                "8839021", michaelHealthDiseases, michaelIsSmoker, michaelMedications);
        InsuranceRequest michaelRequest = insuranceCompany.requestInsurance(michael);
        insuranceCompany.addCustomer(michael);

        Customer lena = new Customer("Lena Lorens", "22 June 2000", "United States", "9901243", "5 Series", 15000, "Gas", 2007);
        insuranceCompany.addCustomer(lena);
        InsuranceRequest lenaRequest = insuranceCompany.requestInsurance(lena);

        Customer jina = new Customer("Jina Lopez", "27 September", "Canada", "98492034", "5 Bedroom", 200000, 300);
        insuranceCompany.addCustomer(jina);
        InsuranceRequest jinaRequest = insuranceCompany.requestInsurance(jina);

        Insurance michaelInsurance = insuranceCompany.issueInsurance(michaelRequest, sam, "health", "09.01.2023", "09.01.2025");
        insuranceCompany.addInsurance(michaelInsurance);

        Insurance lenaVehicleInsurance = insuranceCompany.issueInsurance(lenaRequest, jim, "vehicle", "09.01.2023", "09.01.2025");

        insuranceCompany.addInsurance(lenaVehicleInsurance);

        Insurance jinaHomeInsurance = insuranceCompany.issueInsurance(jinaRequest, jim, "home", "09.01.2023", "09.01.2025");

        insuranceCompany.addInsurance(jinaHomeInsurance);

        Printer.printAll(insuranceCompany.getIssuedInsurances());
    }
}
