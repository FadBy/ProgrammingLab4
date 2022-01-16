package SceneObjects;

public abstract class SceneObject {
    protected String name;

    public String getName() {
        return name;
    }

    public SceneObject(String name) {
        this.name = name;
    }
}
