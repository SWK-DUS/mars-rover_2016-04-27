package org.softwerkskammer.kata.mars.rover;

public class Coordinates {

    public static final int MAX_Y = 42;
    public static final int MAX_X = 13;
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinates)) {
            return super.equals(obj);
        }
        Coordinates other = (Coordinates) obj;
        return (this.x == other.x) && (this.y == other.y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
