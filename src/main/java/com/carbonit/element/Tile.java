package com.carbonit.element;

import com.carbonit.event.TileListener;
import com.carbonit.models.Position;

public interface Tile {

    boolean isEnabled();

    void disable();

    void enable();

    Position getPosition();

    default String getSymbol() {
        return toString();
    }

    TileType getTileType();

    //Map getMap();

    TileListener getTileListener();

    void setTileListener(TileListener tileListener);
}
