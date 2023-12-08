package com.solvd.insurancecompany.filereader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;


public class CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger(CustomFileReader.class);

    public static void readFile(String userFile) {
        try {
            File file = new File(CustomFileReader.class.getClassLoader().getResource(userFile).getFile());
            Set<String> uniqueWords = new HashSet<>();
            String fileText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
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
