package util;

import java.util.ArrayList;

public class Printer {

    public static <T> void printAll(ArrayList<T> list) {
        for (T i : list) {
            System.out.println(i);
        }
    }

    public static void print(Object i) {
        System.out.println(i);
    }
}