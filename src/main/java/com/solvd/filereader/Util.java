package com.solvd.filereader;
import java.io.InputStream;

public class Util {

    public static InputStream getResourceAsStream(String resourceName) {
        ClassLoader classLoader = Util.class.getClassLoader();
        return classLoader.getResourceAsStream(resourceName);
    }
}