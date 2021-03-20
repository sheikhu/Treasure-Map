package com.carbonit.element;

import com.carbonit.models.Position;

public class Mountain extends AbstractTile {

    public Mountain(int x, int y) {
        super(new Position(x, y));
    }

    public Mountain(Position position) {
        this(position.getX(), position.getY());
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    @Override
    public TileType getTileType() {
        return TileType.MOUNTAIN;
    }

    @Override
    public String getSymbol() {
        return "M";
    }
}
