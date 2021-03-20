package com.carbonit.event;

import com.carbonit.element.Treasure;
import com.carbonit.element.Adventurer;
import com.carbonit.element.Tile;

public class DefaultTileListener implements TileListener {

    public DefaultTileListener() {
    }

    @Override
    public void onEnter(Tile tile, Adventurer adventurer) {
        if(tile instanceof Treasure) {
            Treasure t = (Treasure) tile;
            if(t.getTreasureCount() > 0) {
                t.setTreasureCount(t.getTreasureCount() - 1);
                adventurer.setTreasureCount(adventurer.getTreasureCount() + 1);
            }
        }

        tile.disable();

    }

    @Override
    public void onLeave(Tile tile, Adventurer adventurer) {
        tile.enable();
    }
}
