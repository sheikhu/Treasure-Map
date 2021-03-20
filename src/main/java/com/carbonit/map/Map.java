package com.carbonit.map;

import com.carbonit.element.Adventurer;
import com.carbonit.models.Position;
import com.carbonit.element.Tile;

import java.util.List;

public interface Map {

    int getWidth();

    int getHeight();

    void setTile(Tile tile);

    Tile[][] getTiles();

    Tile getTileAt(Position position);

    List<Adventurer> getAdventurers();

    default void printState() {
        System.out.printf("Map(%d,%d)%n", getWidth(), getHeight());
    }

}
