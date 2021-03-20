package com.carbonit.map;

import com.carbonit.element.Adventurer;
import com.carbonit.element.Mountain;
import com.carbonit.element.SimpleAdventurer;
import com.carbonit.element.Tile;
import com.carbonit.move.Orientation;
import com.carbonit.models.Position;
import com.carbonit.move.MoveManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MoveManagerTest {

    private Map map;
    private MoveManager moveManager;

    @Before
    public void setUp() {
        map = new TreasureMap(5, 5);

        moveManager = new MoveManager(map);
    }

    @Test
    public void testModeForward() {
        Adventurer avenger = new SimpleAdventurer(
                "A", new Position(0,0),
                Orientation.SOUTH, Arrays.asList("AA"));

        map.getAdventurers().add(avenger);

        moveManager.forward(avenger);
        moveManager.forward(avenger);
        Assert.assertEquals(avenger.getPosition(), new Position(0, 2));
    }

    @Test
    public void testModeForwardWithMountain() {
        Adventurer avenger = new SimpleAdventurer(
                "A", new Position(0,0),
                Orientation.EAST, Arrays.asList("AA"));

        Tile mountain = new Mountain(new Position(1, 0));
        map.setTile(mountain);
        map.getAdventurers().add(avenger);

        moveManager.forward(avenger);
        moveManager.forward(avenger);
        Assert.assertEquals(avenger.getPosition(), new Position(0, 0));
    }

    @Test
    public void testModeForwardWithGetAroundMountain() {
        Adventurer avenger = new SimpleAdventurer(
                "A", new Position(0,0),
                Orientation.EAST, Arrays.asList("AADAGAAGA".split("")));

        Tile mountain = new Mountain(new Position(1, 0));
        map.setTile(mountain);
        map.getAdventurers().add(avenger);

        moveManager.move(avenger);
        moveManager.move(avenger);
        Assert.assertEquals(avenger.getPosition(), new Position(0, 0));

        moveManager.move(avenger);
        moveManager.move(avenger);
        moveManager.move(avenger);
        moveManager.move(avenger);
        moveManager.move(avenger);
        moveManager.move(avenger);
        moveManager.move(avenger);
        Assert.assertEquals(avenger.getPosition(), new Position(2, 0));
    }
}