package com.carbonit;

import com.carbonit.map.Map;
import com.carbonit.move.MoveManager;
import com.carbonit.element.Adventurer;

public class TreasureHuntSession {

    private final Map map;

    private final MoveManager moveManager;

    public TreasureHuntSession(Map map) {
        this.map = map;
        this.moveManager = new MoveManager(map);
    }

    void run() {

        boolean moreMoves = true;
        while (moreMoves) {

            for (Adventurer adventurer : getMap().getAdventurers()) {

                if (adventurer.canMove()) {
                    String action = adventurer.nextAction();
                    switch (action) {
                        case "A":
                            this.moveManager.forward(adventurer);
                            break;
                        case "G":
                            this.moveManager.left(adventurer);
                            break;
                        case "D":
                            this.moveManager.right(adventurer);
                            break;
                        default:
                            break;
                    }
                }

            }

            moreMoves = getMap().getAdventurers().stream().anyMatch(Adventurer::canMove);

        }

    }


    public Map getMap() {
        return map;
    }
}
