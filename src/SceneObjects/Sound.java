package SceneObjects;

public class Sound {
    private final String text;
    private final String source;

    public Sound(String source, String text) {
        this.source = source;
        this.text = text;
    }

    public void play() {
        System.out.println(this.source + ": " + this.text);
    }
}
