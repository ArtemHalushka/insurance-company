package objects;

public abstract class InsureObject {

    protected int objectID;

    public InsureObject() {
        this.objectID = (int) (Math.random() * 10001);
    }
}
