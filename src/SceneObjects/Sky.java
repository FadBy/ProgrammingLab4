package SceneObjects;

public class Sky extends SceneObject {
    private final boolean isBeautiful;
    private final Color color;

    public Sky(boolean isBeautiful, Color color) {
        super("Небо");
        if (color == null){
            throw new IllegalArgumentException();
        }
        this.isBeautiful = isBeautiful;
        this.color = color;
    }

    public boolean getIsBeautiful() {
        return isBeautiful;
    }

    public Color getColor() {
        return color;
    }
}
