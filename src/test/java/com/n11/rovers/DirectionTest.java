package com.n11.rovers;

import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;

import junit.framework.TestCase;

public class DirectionTest extends TestCase
{

    public DirectionTest( String testName )
    {
        super( testName );
    }

    public void testDirectionOnLeft()
    {
        assertEquals(Direction.NORTH, Direction.EAST.onLeft());
        assertEquals(Direction.WEST, Direction.NORTH.onLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.onLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.onLeft());
    }

    public void testDirectionOnForward()
    {
        assertEquals(new Coordinates(1, 0), Direction.EAST.onForward());
        assertEquals(new Coordinates(-1, 0), Direction.WEST.onForward());
        assertEquals(new Coordinates(0, -1), Direction.SOUTH.onForward());
        assertEquals(new Coordinates(0, 1), Direction.NORTH.onForward());
    }

    public void testDirectionGet()
    {
        assertEquals(Direction.NORTH, Direction.get("N"));
        assertEquals(Direction.WEST, Direction.get("W"));
        assertEquals(Direction.SOUTH, Direction.get("S"));
        assertEquals(Direction.EAST, Direction.get("E"));
    }
}
