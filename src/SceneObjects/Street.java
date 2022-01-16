package SceneObjects;

public class Street extends SceneObject implements Actable {
    private Decor[] decorOutside;
    private int iter = 0;

    public Street(Decor[] decorOutside) {
        super("Улица");
        this.decorOutside = decorOutside;

    }

    public void act() {
        if (iter >= decorOutside.length) {
            return;
        }
        decorOutside[iter].makeNoise();
        iter++;
    }
}
