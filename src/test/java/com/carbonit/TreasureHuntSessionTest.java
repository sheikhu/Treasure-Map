package com.carbonit;

import com.carbonit.element.Adventurer;
import com.carbonit.map.FlatFileInputParser;
import com.carbonit.map.Map;
import com.carbonit.models.Position;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

public class TreasureHuntSessionTest {

    private TreasureHuntSession session;

    @Before
    public void setUp() throws Exception {
        Map map = new FlatFileInputParser(Paths.get("src/test/resources/files/map.txt")).parse();
        session = new TreasureHuntSession(map);
    }

    @Test
    public void testRunSession() {
        this.session.run();

        Adventurer x = session.getMap().getAdventurers().get(0);
        Assert.assertEquals(x.getPosition(), new Position(0, 3));
        Assert.assertEquals(2, x.getTreasureCount());

        // ++ More complex tests
    }
}