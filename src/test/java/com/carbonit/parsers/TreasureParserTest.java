package com.carbonit.parsers;

import com.carbonit.element.Treasure;
import com.carbonit.models.Position;
import org.junit.Assert;
import org.junit.Test;

public class TreasureParserTest {

    private TreasureParser parser = new TreasureParser();

    @Test
    public void testParseTreasure() throws Exception {
        Treasure treasure = parser.parse("T-1-2-4");

        Assert.assertEquals(new Position(1, 2), treasure.getPosition());
        Assert.assertEquals(4, treasure.getTreasureCount());
    }

    @Test(expected = Exception.class)
    public void testParseTreasureFailed() throws Exception {
        Treasure Treasure = parser.parse("T-1--");

        Assert.assertEquals(new Position(1, 4), Treasure.getPosition());
    }

    @Test
    public void testTreasureToString() {
        Treasure treasure = new Treasure(new Position(3, 5), 3);

        String output = parser.toLine(treasure);
        Assert.assertEquals("T-3-5-3", output);
    }
}