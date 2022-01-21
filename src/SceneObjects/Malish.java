package SceneObjects;

import java.util.ArrayList;

public class Malish extends SceneObject implements Actable {
    private Sound walkSound;
    private Sound jumpSound;
    private Sound fallSound;
    private Sound heartSound;
    private Sound agreeSound;
    private final String walkText = "Топ-топ-топ";
    private final String jumpText = "Прыг-скок";
    private final String fallText = "Я падаю-ю-ю";
    private final String heartText = "Тук-тук тук-тук";
    private final String heartName = "Сердце Малыша";
    private final String agreeText = "Давай!";
    private boolean jumpClimbSwitch = false;
    private ArrayList<House> houses;
    private int houseIter = 0;
    private House.Roof currentRoof;
    private House currentHouse;
    private boolean afraid = false;
    private boolean isFalling = false;
    private boolean isAgreed = false;

    public Malish(ArrayList<House> houses) {
        super("Малыш");
        if (houses == null) {
            throw new IllegalArgumentException();
        }
        this.houses = houses;
        walkSound = new Sound(getName(), walkText);
        jumpSound = new Sound(getName(), jumpText);
        fallSound = new Sound(getName(), fallText);
        heartSound = new Sound(heartName, heartText);
        agreeSound = new Sound(getName(), agreeText);
        setCurrentHouse(houses.get(0));
    }

    private void climb() {
        if (afraid) {
            heartSound.play();
        }
        walkSound.play();
    }

    private void jump() {
        if (afraid) {
            heartSound.play();
        }
        jumpSound.play();
    }

    private void fall() {
        fallSound.play();
        isFalling = true;
    }

    private void agree() {
        agreeSound.play();
        isAgreed = true;
    }

    private void setCurrentHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException();
        }
        currentHouse = house;
        currentRoof = house.getRoof();
    }

    private House getNextHouse() throws ActException {
        if (houseIter >= houses.size() - 1) {
            throw new ActException("Малыш не может пройти дальше");
        }
        houseIter++;
        return houses.get(houseIter);
    }

    private boolean moveToNextHouse() throws ActException {
        int a = 0;

        House nextHouse = getNextHouse();
        if (nextHouse == null) {
            return false;
        }
        House previous = currentHouse;
        setCurrentHouse(nextHouse);
        return House.areHousesClose(previous, currentHouse);
    }

    public void act() throws ActException {
        if (isFalling) {
            throw new FallingException("Малыш всё ещё падает");
        }
        if (!isAgreed) {
            agree();
            return;
        }
        if (jumpClimbSwitch) {
            if (moveToNextHouse())
                jump();
            else {
                fall();
            }
        } else {
            climb();
        }

        jumpClimbSwitch = !jumpClimbSwitch;
    }

    public House.Roof getRoof() {
        return currentRoof;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void StopFalling() {
        isFalling = false;
        afraid = true;
    }
}