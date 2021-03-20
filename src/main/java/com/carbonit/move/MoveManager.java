package com.carbonit.move;

import com.carbonit.element.Adventurer;
import com.carbonit.map.Map;
import com.carbonit.models.Position;
import com.carbonit.element.Tile;

public class MoveManager {

    private final Map map;

    public MoveManager(Map map) {
        this.map = map;
    }

    public void move(Adventurer adventurer) {
        String nextAction = adventurer.nextAction();

        switch (nextAction) {
            case "A":
                this.forward(adventurer);
                break;
            case "G":
                this.left(adventurer);
                break;
            case "D":
                this.right(adventurer);
                break;
            default:
                break;
        }
    }
    public void forward(Adventurer adventurer) {
        int offsetX = adventurer.getCompass().offsetX();
        int offsetY = adventurer.getCompass().offsetY();

        Position currentPosition = adventurer.getPosition();

        Position nextPosition = new Position(
                adventurer.getPosition().getX() + offsetX,
                adventurer.getPosition().getY() + offsetY);

        if(nextPosition.getX() >= map.getWidth() || nextPosition.getY() >= map.getHeight())
            return;
        if(map.getTileAt(nextPosition).isEnabled()) {

            Tile tile = map.getTileAt(nextPosition);
            adventurer.setPosition(nextPosition);
            if(tile.getTileListener() != null) {
                tile.getTileListener().onLeave(map.getTileAt(currentPosition), adventurer);
                tile.getTileListener().onEnter(tile, adventurer);
            }

        }

    }

    public void left(Adventurer adventurer) {
        adventurer.getCompass().left();
    }

    public void right(Adventurer adventurer) {
        adventurer.getCompass().right();
    }
}
