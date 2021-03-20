package com.carbonit.element;

import com.carbonit.models.Position;

public class Treasure extends AbstractTile {

    protected int treasureCount;

    public Treasure(int x, int y, int treasureCount) {
        super(new Position(x, y));
        this.treasureCount= treasureCount;
    }


    public Treasure(Position position, int treasureCount) {
        this(position.getX(), position.getY(), treasureCount);
    }


    @Override
    public TileType getTileType() {
        return TileType.TREASURE;
    }

    @Override
    public String toString() {
        return "T(" + this.treasureCount + ")";
    }

    public int getTreasureCount() {
        return this.treasureCount;
    }

    public void setTreasureCount(int treasureCount) {
        this.treasureCount = treasureCount;
    }
}
