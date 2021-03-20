package com.carbonit.element;

import com.carbonit.event.TileListener;
import com.carbonit.models.Position;

abstract public class AbstractTile implements Tile {

    protected Position position;

    protected TileListener tileListener;

    protected boolean enabled = true;

    public AbstractTile(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "AbstractTile{" +
                "position=" + position +
                '}';
    }

    @Override
    public void setTileListener(TileListener tileListener) {
        this.tileListener = tileListener;
    }

    @Override
    public TileListener getTileListener() {
        return this.tileListener;
    }


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }
}
