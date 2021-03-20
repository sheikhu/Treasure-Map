package com.carbonit.parsers;

import com.carbonit.map.Map;
import com.carbonit.map.TreasureMap;
import com.carbonit.models.Position;
import org.junit.Assert;
import org.junit.Test;

public class MapParserTest {

    private MapParser parser = new MapParser();

    @Test
    public void testParseMap() throws Exception {
        Map map = parser.parse("C-2-4");

        Assert.assertEquals(2, map.getWidth());
        Assert.assertEquals(4, map.getHeight());
    }

    @Test(expected = Exception.class)
    public void testParseMapFailed() throws Exception {
        Map map = parser.parse("C-1--");
        Assert.assertEquals(1, map.getWidth());
    }

    @Test
    public void testMapToString() {
        Map map = new TreasureMap(3, 5);
        String output = parser.toLine(map);
        Assert.assertEquals("C-3-5", output);
    }
}