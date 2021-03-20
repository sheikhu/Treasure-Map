package com.carbonit.models;

import com.carbonit.move.Compass;
import com.carbonit.move.Orientation;
import org.junit.Assert;
import org.junit.Test;

public class CompassTest {

    @Test
    public void compassTestRight() {

        Compass compass = new Compass(Orientation.SOUTH);
        compass.right();
        Assert.assertEquals(Orientation.WEST, compass.getCurrentOrientation());

    }

    @Test
    public void compassTestLeft() {

        Compass compass = new Compass(Orientation.SOUTH);
        compass.left();
        Assert.assertEquals(Orientation.EAST, compass.getCurrentOrientation());
        compass.left();
        Assert.assertEquals(Orientation.NORTH, compass.getCurrentOrientation());

        compass.left();
        Assert.assertEquals(Orientation.WEST, compass.getCurrentOrientation());

        compass.left();
        Assert.assertEquals(Orientation.SOUTH, compass.getCurrentOrientation());

    }

    @Test
    public void compassTestMultiMove() {

        Compass compass = new Compass(Orientation.NORTH);
        compass.right();
        compass.right();
        Assert.assertEquals(Orientation.SOUTH, compass.getCurrentOrientation());

        compass.right();
        compass.right();
        Assert.assertEquals(Orientation.NORTH, compass.getCurrentOrientation());

        compass.right();
        compass.right();
        compass.right();
        Assert.assertEquals(Orientation.WEST, compass.getCurrentOrientation());

    }

    @Test
    public void compassTestMultiDirection() {

        Compass compass = new Compass(Orientation.NORTH);
        compass.right();
        compass.left();
        Assert.assertEquals(Orientation.NORTH, compass.getCurrentOrientation());

        compass.right();
        compass.right();
        compass.left();
        Assert.assertEquals(Orientation.EAST, compass.getCurrentOrientation());

        compass.right();
        compass.left();
        compass.right();
        compass.right();
        compass.right();
        Assert.assertEquals(Orientation.NORTH, compass.getCurrentOrientation());

    }
}
