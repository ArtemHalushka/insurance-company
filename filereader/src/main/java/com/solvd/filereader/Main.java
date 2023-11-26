package com.solvd.filereader;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Set<String> uniqueWords = new HashSet<>();
            String fileText = FileUtils.readFileToString(new File("input.txt"), "UTF-8");
            String[] textArray = StringUtils.split(fileText);
            for (String word : textArray) {
                String cleanWord = StringUtils.strip(word, ".,;:\"'()[]{}?!-").toLowerCase();
                uniqueWords.add(cleanWord);
            }
            FileUtils.writeStringToFile(new File("input.txt"), Integer.toString(uniqueWords.size()), "UTF-8");
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
