package com.carbonit.move;

import java.util.Arrays;

public class Compass {
    protected int currentIndex;
    protected Orientation[] directions;

    public Compass(Orientation defaultOrientation) {
        directions = new Orientation[]{Orientation.SOUTH, Orientation.WEST, Orientation.NORTH, Orientation.EAST};
        currentIndex = Arrays.asList(directions).indexOf(defaultOrientation);
    }

    public Orientation left() {
        if (currentIndex == 0)
            currentIndex = 3;
        else
            currentIndex--;

        return directions[currentIndex];
    }

    public Orientation right() {
        if (currentIndex == 3)
            currentIndex = 0;
        else
            currentIndex++;

        return directions[currentIndex];
    }

    public Orientation getCurrentOrientation() {
        return directions[currentIndex];
    }


    public static Orientation getOrientation(String s) {
        switch (s) {
            case "S":
                return Orientation.SOUTH;
            case "N":
                return Orientation.NORTH;
            case "E":
                return Orientation.EAST;
            case "O":
                return Orientation.WEST;
        }

        throw new RuntimeException("Orientation" + s + "not found");
    }

    public int offsetX() {
        Orientation currentOrientation = getCurrentOrientation();
        switch (currentOrientation) {
            case WEST:
                return -1;
            case EAST:
                return 1;
            default:
                return 0;
        }
    }

    public int offsetY() {
        Orientation currentOrientation = getCurrentOrientation();

        switch (currentOrientation) {
            case NORTH:
                return -1;
            case SOUTH:
                return 1;
            default:
                return 0;
        }
    }
}