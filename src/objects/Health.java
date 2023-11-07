package objects;

import java.util.Arrays;

public class Health extends InsureObject {

    private String[] healthDiseases;
    private boolean smoker;
    private String[] medications;
    private int objectId = (int) (Math.random() * 10001);


    public Health(String[] healthDiseases, boolean smoker, String[] medications) {
        this.healthDiseases = healthDiseases;
        this.smoker = smoker;
        this.medications = medications;
        this.objectId = objectId;
    }

    public String[] getHealthDiseases() {
        return healthDiseases;
    }

    public String[] getMedications() {
        return medications;
    }

    public boolean isSmoker() {
        return smoker;
    }

    @Override
    public String toString() {
        String healthDiseasesString = Arrays.toString(healthDiseases);
        String medicationsString = Arrays.toString(medications);

        return "Health: " + "id (" + objectId + ") " + healthDiseasesString + " " + " smoker " + "(" + smoker + ") " + medicationsString;
    }
}

