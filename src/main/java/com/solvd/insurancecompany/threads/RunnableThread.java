package com.solvd.insurancecompany.threads;

import com.solvd.insurancecompany.filereader.CustomFileReader;

public class RunnableThread implements Runnable {
    private String fileName;

    public RunnableThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        CustomFileReader.readFile(fileName);
    }
}
