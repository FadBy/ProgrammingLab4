import java.util.ArrayList;

import SceneObjects.*;

public class ObjectsHolder {
    private ArrayList<SceneObject> objects = new ArrayList<SceneObject>();
    private ArrayList<House> houses = new ArrayList<House>();
    private ArrayList<Window> windows = new ArrayList<Window>();
    private ArrayList<Decor> decors = new ArrayList<Decor>();
    private int houseIter = 0;
    private Malish malish;
    private Karlson karlson;
    private Street street;
    private Sky sky;


    public ObjectsHolder() {
        loadObjects();
    }

    public void loadEvents(EventSystem eventSystem) {
        if (eventSystem == null){
            throw new IllegalArgumentException();
        }
        eventSystem.addNextEvent(karlson, 1);
        eventSystem.addNextEvent(malish, 1);
        eventSystem.addNextEvent(karlson, 1);
        eventSystem.addNextEvent(new Actable() {
            @Override
            public void act() {
                System.out.println("Вечер смеркается");
            }
        }, 1);
        eventSystem.addNextEvent(new Actable() {
            @Override
            public void act() {
                System.out.println("Парк зеленеет");
            }
        }, 1);
        eventSystem.addNextEvent(street, 4);
        eventSystem.addNextEvents(new ArrayList<Actable>(windows), 1);
        eventSystem.addNextEvent(malish, 4);
        eventSystem.addNextEvent(karlson, 1);
        eventSystem.addNextEvent(malish, 4);
        eventSystem.addNextEvent(karlson, 1);
    }

    private void loadObjects() {
        class WindowAdder {
            private final ArrayList<Window> windows;

            public WindowAdder(ArrayList<Window> windows) {
                this.windows = windows;
            }

            public Window[] getDecorInterval(int start, int end) {
                Window[] windowsInt = new Window[end - start + 1];
                for (int i = 0; i < windowsInt.length; i++) {
                    windowsInt[i] = windows.get(i + start);
                }
                return windowsInt;
            }
        }

        decors.add(new Decor("Тихий разговор людей", "бла-бла-бла"));
        decors.add(new Decor("Детский смех", "Хе-хе"));
        decors.add(new Decor("Звяканье посуды", "Звяк-звяк"));
        decors.add(new Decor("Детский плач", "а-а-а"));
        decors.add(new Decor("Лай собаки", "гав-гав"));
        decors.add(new Decor("Бренчание на пианино", "До-ре-ми-фа-соль"));
        decors.add(new Decor("Мотоцикл", "Врум-врум"));
        decors.add(new Decor("Цокот копыт", "Цок-цок"));
        decors.add(new Decor("Тарахтение телеги", "Тарах-тарах"));
        decors.add(new Decor("Тополя", "*Поднимается запах листвы*"));
        windows.add(new Window(true, decors.get(0)));
        windows.add(new Window(true, decors.get(1)));
        windows.add(new Window(true, decors.get(2)));
        windows.add(new Window(true, decors.get(3)));
        windows.add(new Window(true, decors.get(4)));
        windows.add(new Window(true, decors.get(5)));
        WindowAdder windowAdder = new WindowAdder(windows);
        houses.add(new House(0, windowAdder.getDecorInterval(0, 2)));
        houses.add(new House(1, windowAdder.getDecorInterval(2, 4)));
        houses.add(new House(3, windowAdder.getDecorInterval(5, 5)));
        houses.add(new House(4, new Window[0]));
        street = new Street(new Decor[]{
                decors.get(9),
                decors.get(6),
                decors.get(7),
                decors.get(8)
        });
        malish = new Malish(houses);
        karlson = new Karlson(malish);
        sky = new Sky(true, Color.BLUE);
        objects.add(malish);
        objects.add(karlson);
        objects.addAll(houses);
        objects.add(street);
        objects.add(sky);
    }

    public House getNextHouse() {
        if (houseIter >= houses.size()) {
            return null;
        }
        return houses.get(houseIter++);
    }

    public House getStartingHouse() {
        if (houses.size() == 0) {
            return null;
        }
        return houses.get(0);
    }
}
