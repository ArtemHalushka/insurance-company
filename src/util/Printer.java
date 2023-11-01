package util;

import insurances.Insurance;
import objects.Home;
import objects.Vehicle;
import people.Person;

import java.util.ArrayList;

public class Printer {

    public static <T> void printAll(ArrayList<T> list) {
        for (T i : list) {
            System.out.println(i);
        }
    }

    public static void print(String string) {
        System.out.println(string);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(double price) {
        System.out.println(price);
    }

    public static void print(Vehicle car) {
        System.out.println(car);
    }

    public static void print(Person person) {
        System.out.println(person);
    }

    public static void print(Home home) {
        System.out.println(home);
    }

    public static void print(Insurance ins) {
        System.out.println(ins);
    }
}
