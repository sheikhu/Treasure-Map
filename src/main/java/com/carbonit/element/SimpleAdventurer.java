package com.carbonit.element;

import com.carbonit.event.TileListener;
import com.carbonit.move.Compass;
import com.carbonit.move.Orientation;
import com.carbonit.models.Position;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class SimpleAdventurer implements Adventurer {

    private final String name;
    private Position position;
    private final Queue<String> moves;
    private int treasureCount ;

    private final Compass compass;

    public SimpleAdventurer(String name, Position position, Orientation defaultOrientation, Collection<String> movements) {
        this.name = name;
        this.position = position;
        this.moves = new ArrayDeque<>();
        this.moves.addAll(movements);
        this.treasureCount = 0;
        compass = new Compass(defaultOrientation);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean canMove() {
        return !this.moves.isEmpty();
    }


    @Override
    public Compass getCompass() {
        return this.compass;
    }


    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public TileListener getTileListener() {
        return null;
    }

    @Override
    public void setTileListener(TileListener tileListener) {

    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int getTreasureCount() {
        return this.treasureCount;
    }

    @Override
    public void setTreasureCount(int treasureCount) {
        this.treasureCount = treasureCount;
    }

    @Override
    public String nextAction() {
        if(!this.moves.isEmpty())
            return this.moves.poll();
        return "";
    }

    @Override
    public String toString() {
        return "A";
    }
}
