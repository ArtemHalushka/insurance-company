package util;

import java.util.ArrayList;

public interface IPrint {

    static <T> void printAll(ArrayList<T> list) {
        for (T i : list) {
            System.out.println(i);
        }
    }

    static void print(Object i) {
        System.out.println(i);
    }
}