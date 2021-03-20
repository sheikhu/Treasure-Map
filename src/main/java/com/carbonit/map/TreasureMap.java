package com.carbonit.map;

import com.carbonit.element.Mountain;
import com.carbonit.element.Plain;
import com.carbonit.element.Treasure;
import com.carbonit.event.DefaultTileListener;
import com.carbonit.element.Adventurer;
import com.carbonit.models.Position;
import com.carbonit.element.Tile;

import java.util.ArrayList;
import java.util.List;

public class TreasureMap implements Map {

    private final int width;
    private final int height;
    protected Tile[][] tiles;

    protected List<Adventurer> adventurers;

    public TreasureMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.adventurers = new ArrayList<>();
        this.fill(); // fill with default case type
    }

    public void fill() {

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                Plain p = new Plain(new Position(i, j));
                p.setTileListener(new DefaultTileListener());
                p.enable();
                this.tiles[i][j] = p;
            }
        }
    }


    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setTile(Tile tile) {
        if(tileIsOutOfMap(tile))
            throw new RuntimeException("Tile is out of bounds");
        this.tiles[tile.getPosition().getX()][tile.getPosition().getY()] = tile;
    }

    private boolean tileIsOutOfMap(Tile tile) {
        return tile.getPosition().getX() >= this.width || tile.getPosition().getY() >= height;
    }

    @Override
    public void printState() {
        for (int j = 0; j < this.height; j++) {

            for (int i = 0; i < this.width; i++) {

                String symbol = String.format("%-15s", this.tiles[i][j].getSymbol());
                System.out.print(symbol);

            }
            System.out.println(System.lineSeparator());
        }
    }

    @Override
    public Tile[][] getTiles() {
        return tiles;
    }

    @Override
    public Tile getTileAt(Position position) {
        return this.tiles[position.getX()][position.getY()];
    }

    @Override
    public List<Adventurer> getAdventurers() {
        return this.adventurers;
    }

}
