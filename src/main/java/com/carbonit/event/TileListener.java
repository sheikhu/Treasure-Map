package com.carbonit.event;

import com.carbonit.element.Adventurer;
import com.carbonit.element.Tile;

public interface TileListener {

    void onEnter(Tile tile, Adventurer adventurer);

    void onLeave(Tile tile, Adventurer adventurer);
}
