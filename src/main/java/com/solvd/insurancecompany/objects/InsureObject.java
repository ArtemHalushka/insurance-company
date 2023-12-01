package com.solvd.insurancecompany.objects;

public abstract class InsureObject {

    protected String objectName;
    protected int objectId;
    protected ObjectType objectType;

    public InsureObject(String objectName) {
        this.objectId = (int) (Math.random() * 10001);
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public ObjectType getObjectType() {
        return objectType;
    }
}
