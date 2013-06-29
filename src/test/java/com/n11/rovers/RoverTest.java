package com.n11.rovers;

import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;
import com.n11.rovers.models.Rover;
import com.n11.rovers.models.RoverKAFA500;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RoverTest extends TestCase
{
    public RoverTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( RoverTest.class );
    }

    public void test()
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        assertNotNull(rover);
        assertEquals(new Coordinates(0, 0), rover.getLocation());
        assertEquals(Direction.NORTH, rover.getHeading());
    }
}
