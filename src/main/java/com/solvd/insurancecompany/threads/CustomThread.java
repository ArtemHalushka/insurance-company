package com.solvd.insurancecompany.threads;

import com.solvd.insurancecompany.filereader.CustomFileReader;

public class CustomThread extends Thread {
    private String fileName;

    public CustomThread(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void joinThread() throws InterruptedException {
        this.join();
    }

    @Override
    public void run() {
        CustomFileReader.readFile(fileName);
    }
}