package com.solvd.insurancecompany.objects;

public abstract class InsureObject {

    protected int objectId;

    public InsureObject() {
        this.objectId = (int) (Math.random() * 10001);
    }
}
