package com.solvd.insurancecompany.objects;

import java.util.HashSet;

public class Health extends InsureObject {

    private static HashSet<HealthDisease> healthDiseases  = new HashSet<>();
    private boolean smoker;
    private HashSet<Medication> medications = new HashSet<>();
    private final ObjectType objectType;

    public Health(String type, boolean smoker) {
        super(type);
        this.smoker = smoker;
        objectType = ObjectType.HEALTH;
    }

    public HashSet<HealthDisease> getHealthDiseases() {
        return healthDiseases;
    }

    public void addHealthDisease(HealthDisease disease) {
        healthDiseases.add(disease);
    }

    public void removeHealthDisease(HealthDisease disease) {
        healthDiseases.remove(disease);
    }

    public void addMedications(Medication medication) {
        medications.add(medication);
    }

    public void removeMedications(Medication medication) {
        medications.remove(medication);
    }

    public HashSet<Medication> getMedications() {
        return medications;
    }

    public boolean isSmoker() {
        return smoker;
    }

    @Override
    public String toString() {

        return "Health: id (" + objectId + ") " + String.join(" ", healthDiseases.toString()) + " smoker (" + smoker + ") " + String.join(" ", medications.toString());
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }
}