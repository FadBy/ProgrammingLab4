import java.util.ArrayList;

import SceneObjects.ActException;
import SceneObjects.Actable;
import SceneObjects.FallingException;

public class EventSystem {
    private final ArrayList<Actable> actions;

    public EventSystem() {
        actions = new ArrayList<>();
    }

    public void StartAction() {
        for (Actable action : actions) {
            try {
                action.act();
            } catch (ActException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addNextEvent(Actable event, int count) {
        if (event == null || count <= 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < count; i++) {
            actions.add(event);
        }
    }

    public void addNextEvents(ArrayList<Actable> events, int count) {
        if (events == null || count <= 0) {
            throw new IllegalArgumentException();
        }
        for (Actable event : events) {
            addNextEvent(event, count);
        }
    }

    public void insertEvent(int index, Actable event) {
        if (event == null || index < 0 || index > actions.size()) {
            throw new IllegalArgumentException();
        }
        actions.add(index, event);
    }
}
