package com.carbonit.parsers;

import com.carbonit.element.Adventurer;
import com.carbonit.element.SimpleAdventurer;
import com.carbonit.element.TileType;
import com.carbonit.move.Orientation;
import com.carbonit.models.Position;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AdventurerParserTest extends TestCase {

    private AdventurerParser parser = new AdventurerParser();
    @Test
    public void testParseAdventurer() throws Exception {
        Adventurer adventurer = parser.parse("A-X-1-2-S-AAD");
        Assert.assertEquals("X", adventurer.getName());
        Assert.assertEquals(new Position(1, 2), adventurer.getPosition());
        Assert.assertEquals(adventurer.getCompass().getCurrentOrientation(), Orientation.SOUTH);
        Assert.assertEquals(TileType.ADVENTURER, adventurer.getTileType());
        // moves
        Assert.assertTrue(adventurer.canMove());
        Assert.assertEquals(adventurer.nextAction(), "A");
        Assert.assertEquals(adventurer.nextAction(), "A");
        Assert.assertEquals(adventurer.nextAction(), "D");
        Assert.assertFalse(adventurer.canMove());
    }

    @Test
    public void testAdventurerToString() {
        Adventurer adventurer = new SimpleAdventurer(
                "Foo",
                new Position(2, 3), Orientation.SOUTH, Arrays.asList("A"));
        adventurer.setTreasureCount(2);
        String output = parser.toLine(adventurer);
        Assert.assertEquals("A-Foo-2-3-S-2", output);
    }
}