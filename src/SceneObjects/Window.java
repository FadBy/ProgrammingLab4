package SceneObjects;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Window extends SceneObject implements Actable {
    public boolean isOpened;
    private Decor decor;

    public Window(boolean isOpened, Decor decor) {
        super("Окно");
        this.isOpened = isOpened;
        this.decor = decor;
    }

    public Window(boolean isOpened) {
        this(isOpened, null);
    }

    @Override
    public void act() {
        if (isOpened && decor != null) {
            decor.makeNoise();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return isOpened == window.isOpened && Objects.equals(decor, window.decor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpened, decor);
    }

    @Override
    public String toString() {
        return (isOpened ? "Открытое" : "Закрытое") + "окно: " + decor.toString();
    }
}
