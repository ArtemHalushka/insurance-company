package objects;

import java.util.HashSet;

public class Health extends InsureObject {

    private HashSet<String> healthDiseases  = new HashSet<>();
    private boolean smoker;
    private HashSet<String> medications = new HashSet<>();

    public Health(boolean smoker) {
        super();
        this.smoker = smoker;
        this.objectId = objectId;
    }

    public HashSet<String> getHealthDiseases() {
        return healthDiseases;
    }

    public void addHealthDisease(String disease) {
        healthDiseases.add(disease);
    }

    public void removeHealthDisease(String disease) {
        healthDiseases.remove(disease);
    }

    public void addMedications(String medication) {
        medications.add(medication);
    }

    public void removeMedications(String medication) {
        medications.remove(medication);
    }

    public HashSet<String> getMedications() {
        return medications;
    }

    public boolean isSmoker() {
        return smoker;
    }

    @Override
    public String toString() {

        return "Health: id (" + objectId + ") " + String.join(" ", healthDiseases) + " smoker (" + smoker + ") " + String.join(" ", medications);
    }
}