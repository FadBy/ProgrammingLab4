import java.util.ArrayList;

import SceneObjects.ActException;
import SceneObjects.Actable;
import SceneObjects.FallingException;

public class EventSystem {
    private ArrayList<Actable> actions;

    public EventSystem() {
        actions = new ArrayList<>();
    }

    public void StartAction() {
        for (Actable action : actions) {
            try {
                action.act();
            } catch (FallingException | ActException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addNextEvent(Actable event, int count) {
        for (int i = 0; i < count; i++) {
            actions.add(event);
        }

    }

    public void addNextEvents(ArrayList<Actable> events, int count) {
        for (Actable event : events) {
            addNextEvent(event, count);
        }
    }

    public void insertEvent(int index, Actable event) {
        actions.add(index, event);
    }
}
