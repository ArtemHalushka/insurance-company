package com.solvd.insurancecompany.threads;

import com.solvd.filereader.FileReader;

public class RunnableThread implements Runnable {
    private String fileName;

    public RunnableThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        FileReader.readFile(fileName);
    }
}
