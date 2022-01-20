public class Scene {
    private final TimeOfDay timeOfDay = TimeOfDay.EVENING;
    private final Difficulty difficulty = Difficulty.HARD;

    private final EventSystem eventSystem;
    private final ObjectsHolder objHolder;

    public Scene() {
        eventSystem = new EventSystem();
        objHolder = new ObjectsHolder();
        objHolder.loadEvents(eventSystem);
    }

    public void Run() {
        eventSystem.StartAction();
    }

    public TimeOfDay timeOfDay() {
        return timeOfDay;
    }

    public Difficulty difficulty() {
        return difficulty;
    }

    public enum TimeOfDay {
        NIGHT,
        MORNING,
        AFTERNOON,
        EVENING
    }

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD,
        INSANE
    }
}
