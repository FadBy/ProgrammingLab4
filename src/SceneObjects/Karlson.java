package SceneObjects;

public class Karlson extends SceneObject implements Actable {
    private final Sound catchSound;
    private final Sound offerSound;
    private final String catchText = "Хвать...";
    private final String offerText = "Пошли гулять по крышам";
    private final Malish malish;
    private boolean isOffered = false;
    private boolean isCatching = false;

    public Karlson(Malish malish) {
        super("Карлсон");
        if (malish == null){
            throw new IllegalArgumentException();
        }
        this.malish = malish;
        catchSound = new Sound(getName(), catchText);
        offerSound = new Sound(getName(), offerText);
    }

    @Override
    public void act() throws ActException {
        if (!isOffered) {
            offer();
            return;
        }
        if (!isCatching) {
            catchMalish();
            isCatching = true;
            return;
        }
        if (malish.isFalling()) {
            catchMalish();
        } else {
            throw new ActException("Карлсон ничего не сделал");
        }
    }

    private void catchMalish() {
        catchSound.play();
        malish.StopFalling();
    }

    private void offer() {
        offerSound.play();
        isOffered = true;
    }
}
