package com.carbonit.element;

import com.carbonit.models.Position;

public class Plain extends AbstractTile {

    public Plain(Position position) {
        super(position);
    }

    @Override
    public TileType getTileType() {
        return TileType.PLAIN;
    }

    @Override
    public String getSymbol() {
        return ".";
    }
}
