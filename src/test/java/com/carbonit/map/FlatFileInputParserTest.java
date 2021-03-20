package com.carbonit.map;

import com.carbonit.element.Mountain;
import com.carbonit.element.Tile;
import com.carbonit.models.Position;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

public class FlatFileInputParserTest {

    private FlatFileInputParser parser;

    @Before
    public void setUp() {
        parser = new FlatFileInputParser(Paths.get("src/test/resources/files/map.txt"));
    }

    @Test
    public void testParseMapInfo() throws Exception {
        Map map = this.parser.parse();

        Assert.assertEquals(3, map.getWidth());
        Assert.assertEquals(4, map.getHeight());

        Tile mountain1 = map.getTileAt(new Position(1, 1));
        Assert.assertTrue(mountain1 instanceof Mountain);

        Tile mountain2 = map.getTileAt(new Position(2, 2));
        Assert.assertTrue(mountain2 instanceof Mountain);

        Assert.assertEquals(1, map.getAdventurers().size());

    }
}