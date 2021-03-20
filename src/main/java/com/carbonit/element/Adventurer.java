package com.carbonit.element;

import com.carbonit.move.Compass;
import com.carbonit.models.Position;

public interface Adventurer extends Tile {

    String getName();

    boolean canMove();

    Compass getCompass();

    void setPosition(Position position);

    int getTreasureCount();

    void setTreasureCount(int treasureCount);

    String nextAction();

    @Override
    default TileType getTileType() {
        return TileType.ADVENTURER;
    }

    @Override
    default boolean isEnabled() {
        return false;
    }

    @Override
    default void enable() {

    }

    @Override
    default void disable() {

    }

    @Override
    default String getSymbol() {
        return String.format("A(%s)", this.getName());
    }
}
