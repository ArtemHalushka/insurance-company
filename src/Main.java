import insurances.HealthInsurance;
import insurances.HomeInsurance;
import insurances.VehicleInsurance;
import objects.Home;
import objects.Vehicle;
import people.Customer;
import people.Employee;
import util.Printer;

public class Main {

    public static void main(String[] args) {

        InsuranceCompany insuranceCompany = new InsuranceCompany("Reico");

        Employee jim = new Employee("Jim Turner", "10 October 1999", "United states", 919883992, "Lead");
        insuranceCompany.addEmployee(jim);

        Employee sam = new Employee("Sam Smith", "3 May 1989", "Canada", 992039203, "Clerk");
        insuranceCompany.addEmployee(sam);

        String[] michaelHealthDiseases = {"Diabetes", "High blood pressure"};
        String[] michaelMedications = {"Mezim"};
        boolean michaelIsSmoker = true;
        Customer michael = new Customer("Michael Flint", "11 December 2001", "United states",
                8839021, michaelHealthDiseases, michaelIsSmoker, michaelMedications);
        insuranceCompany.addCustomer(michael);

        Customer lena = new Customer("Lena Lorens", "22 June 2000", "United States", 9901231);
        insuranceCompany.addCustomer(lena);

        Customer jina = new Customer("Jina Lopez", "27 September", "Canada", 98492034);
        insuranceCompany.addCustomer(jina);

        HealthInsurance michaelInsurance = sam.issueHealthInsurance(michael, "High health coverage", "22.10.2022", "22.10.2024",
                michaelHealthDiseases, michaelIsSmoker, michaelMedications);
        insuranceCompany.addInsurance(michaelInsurance);

        Vehicle bmw = new Vehicle("5 Series", 15000, "Gas", 2007);
        VehicleInsurance jimVehcileInsurance = jim.issueVehicleInsurance(lena, "Business vehicle coverage", "09.01.2023", "09.01.2025", bmw);
        insuranceCompany.addInsurance(jimVehcileInsurance);

        Home twoFloorHome = new Home("5 Bedroom home with balcony", 200000, 300);
        HomeInsurance jinaHomeIsurance = sam.issueHomeInsurance(jina, "Natural disaster coverage", "01.01.2007", "01.01.2030", twoFloorHome);
        insuranceCompany.addInsurance(jinaHomeIsurance);

        Printer.print(bmw);
    }
}
