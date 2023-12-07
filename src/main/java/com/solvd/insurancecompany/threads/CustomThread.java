package com.solvd.insurancecompany.threads;

import com.solvd.insurancecompany.filereader.CustomFileReader;

public class CustomThread extends Thread {
    private String fileName;

    public CustomThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        CustomFileReader.readFile(fileName);
    }
}