package com.carbonit.writer;

import com.carbonit.element.Adventurer;
import com.carbonit.element.Mountain;
import com.carbonit.element.SimpleAdventurer;
import com.carbonit.element.Treasure;
import com.carbonit.map.Map;
import com.carbonit.map.TreasureMap;
import com.carbonit.move.Orientation;
import com.carbonit.models.Position;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class MapOutputWriterTest {

    private Map map;
    OutputWriter writer;
    File output;

    @Before
    public void setUp() throws Exception {
        map = new TreasureMap(5, 5);
        output = File.createTempFile("map", ".tmp");
        writer = new MapOutputWriter(this.map, output.getAbsolutePath());
    }

    @Test
    public void testWriteSessionToFile() throws IOException {

        map.setTile(new Mountain(new Position(1, 1)));
        map.setTile(new Mountain(new Position(2, 2)));
        map.setTile(new Treasure(new Position(3, 3), 2));
        map.setTile(new Treasure(new Position(3, 1), 0));

        Adventurer adventurer = new SimpleAdventurer("Foo",
                new Position(4, 4), Orientation.EAST,
                Arrays.asList("A")
                );
        adventurer.setTreasureCount(1);

        map.getAdventurers().add(adventurer);

        writer.write();

        List<String> lines = Files.readAllLines(output.toPath());
        String out = String.join(System.lineSeparator(), lines);

        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("C-5-5");
        joiner.add("M-1-1");
        joiner.add("M-2-2");
        joiner.add("T-3-3-2");
        joiner.add("A-Foo-4-4-E-1");
        Assert.assertEquals(joiner.toString(), out.trim());

    }

    @After
    public void tearDown() {
        if(output != null) {
            output.delete();
        }
    }

}