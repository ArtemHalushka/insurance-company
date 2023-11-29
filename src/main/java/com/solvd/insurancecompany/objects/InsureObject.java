package com.solvd.insurancecompany.objects;

public abstract class InsureObject {

    protected String type;
    protected int objectId;

    public InsureObject(String type) {
        this.objectId = (int) (Math.random() * 10001);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
