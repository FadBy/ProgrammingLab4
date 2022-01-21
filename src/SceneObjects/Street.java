package SceneObjects;

public class Street extends SceneObject implements Actable {
    private final Decor[] decorOutside;
    private int iter = 0;

    public Street(Decor[] decorOutside) {
        super("Улица");
        if (decorOutside == null){
            throw new IllegalArgumentException();
        }
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
