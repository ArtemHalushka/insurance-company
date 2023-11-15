package util;

import company.PersonLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Printer {

    private static final Logger LOGGER = LogManager.getLogger(Printer.class);

    public static <T> void printAll(ArrayList<T> list) {
        for (T i : list) {
            LOGGER.info(i);
        }
    }

    public static void print(Object i) {
        LOGGER.info(i);
    }
}