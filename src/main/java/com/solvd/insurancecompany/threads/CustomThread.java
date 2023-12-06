package com.solvd.insurancecompany.threads;

import com.solvd.filereader.FileReader;

public class CustomThread extends Thread {
    private String fileName;

    public CustomThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        FileReader.readFile(fileName);
    }
}