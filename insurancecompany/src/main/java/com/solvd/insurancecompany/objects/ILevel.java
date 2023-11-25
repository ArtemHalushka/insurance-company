package com.solvd.insurancecompany.objects;

public interface ILevel {

    String HIGH_LEVEL = "High level";
    String MEDIUM_LEVEL = "Medium level";
    String LOW_LEVEL = "Low level";
    int VEHICLE_LEVEL_YEAR = 2010;
    int VEHICLE_LEVEL_PRICE = 9999;
    int HOME_LEVEL_PRICE = 59999;
    int HOME_LEVEL_M2 = 30;

    String insuranceObjectLevel();
}
