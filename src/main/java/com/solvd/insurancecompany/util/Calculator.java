package com.solvd.insurancecompany.util;

public class Calculator {

    private double firstNumber;
    private double secondNumber;

    public Calculator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double addNumbers() {
        return firstNumber + secondNumber;
    }

    public double multiplyNumbers() {
        return firstNumber * secondNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }
}
