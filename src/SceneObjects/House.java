package SceneObjects;

import java.util.Arrays;
import java.util.Objects;

public class House extends SceneObject implements Building {
    private final Roof roof;
    private final Window[] windows;
    private final int coord;

    public House(int coord, Window[] windows) {
        super("Дом");
        roof = new Roof(AngleType.BIZARRE);
        this.windows = windows;
        this.coord = coord;
    }

    public int getCoord() {
        return coord;
    }

    public static boolean areHousesClose(House first, House second) {
        return Math.abs(first.getCoord() - second.getCoord()) <= 1;
    }

    public Roof getRoof() {
        return roof;
    }

    public Window[] getWindows() {
        return windows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return coord == house.coord && Objects.equals(roof, house.roof) && Arrays.equals(windows, house.windows);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(roof, coord);
        result = 31 * result + Arrays.hashCode(windows);
        return result;
    }

    @Override
    public String toString() {
        return getName() + ": " + coord;
    }

    public class Roof {
        private final AngleType angle;

        public Roof(AngleType angle) {
            this.angle = angle;
        }

        public AngleType getAngle() {
            return angle;
        }

        public House getHouse() {
            return House.this;
        }
    }
}
