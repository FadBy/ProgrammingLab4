package SceneObjects;

import java.util.Objects;

public class Decor extends SceneObject {
    private Sound sound;
    private String soundText;

    public Decor(String name, String soundText) {
        super(name);
        this.soundText = soundText;
        sound = new Sound(name, soundText);
    }

    public void makeNoise() {
        sound.play();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decor decor = (Decor) o;
        return Objects.equals(sound, decor.sound) && Objects.equals(soundText, decor.soundText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sound, soundText);
    }

    public String toString() {
        return "Декор: " + getName() + " - " + soundText;
    }
}
