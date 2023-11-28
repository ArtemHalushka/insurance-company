package com.solvd.filereader;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;


public class Main {

    static {
        System.setProperty("log4j2.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            File file = new File(Main.class.getClassLoader().getResource("input.txt").getFile());
            Set<String> uniqueWords = new HashSet<>();
            String fileText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            LOGGER.info(fileText);
            String[] textArray = StringUtils.split(fileText);
            for (String word : textArray) {
                String cleanWord = StringUtils.strip(word, ".,;:\"'()[]{}?!-").toLowerCase();
                uniqueWords.add(cleanWord);
            }
            FileUtils.writeStringToFile(file, Integer.toString(uniqueWords.size()), "UTF-8");
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
