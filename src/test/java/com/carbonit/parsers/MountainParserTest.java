package com.carbonit.parsers;

import com.carbonit.element.Mountain;
import com.carbonit.element.TileType;
import com.carbonit.models.Position;
import org.junit.Assert;
import org.junit.Test;

public class MountainParserTest {

    private MountainParser parser = new MountainParser();

    @Test
    public void testParseMountain() throws Exception {
        Mountain mountain = parser.parse("M-1-4");

        Assert.assertEquals(new Position(1, 4), mountain.getPosition());
        Assert.assertEquals(TileType.MOUNTAIN, mountain.getTileType());
        Assert.assertFalse(mountain.isEnabled());
    }

    @Test(expected = Exception.class)
    public void testParseMountainFailed() throws Exception {
        Mountain mountain = parser.parse("M-1--");

        Assert.assertEquals(new Position(1, 4), mountain.getPosition());
    }

    @Test
    public void testMountainToString() {
        Mountain mountain = new Mountain(new Position(3, 5));
        String output = parser.toLine(mountain);
        Assert.assertEquals("M-3-5", output);
    }
}