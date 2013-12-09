package com.n11.rovers;

import com.blackburn.rovers.commands.CommandFactory;
import com.blackburn.rovers.exception.CommandInitializationException;
import com.blackburn.rovers.exception.OutOfPlateauException;
import com.blackburn.rovers.exception.RoverNotSetException;
import com.blackburn.rovers.models.Coordinates;
import com.blackburn.rovers.models.Direction;
import com.blackburn.rovers.models.Rover;
import com.blackburn.rovers.models.RoverKAFA500;

import junit.framework.TestCase;

public class RoverTest extends TestCase
{
    public RoverTest( String testName )
    {
        super( testName );
    }

    public void testRover()
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        assertNotNull(rover);
        assertEquals(new Coordinates(0, 0), rover.getLocation());
        assertEquals(Direction.NORTH, rover.getHeading());
    }

    public void testDisplayLocation() throws RoverNotSetException, CommandInitializationException, OutOfPlateauException {
    	Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
    	assertEquals("0 0 N", rover.displayPosition());
    	
    	rover.execute(CommandFactory.createCommand("M"));
    	rover.execute(CommandFactory.createCommand("R"));
    	rover.execute(CommandFactory.createCommand("M"));
    	
    	assertEquals("1 1 E", rover.displayPosition());
    	
    	rover.execute(CommandFactory.createCommand("M"));
    	rover.execute(CommandFactory.createCommand("M"));
    	rover.execute(CommandFactory.createCommand("L"));
    	
    	assertEquals("3 1 N", rover.displayPosition());
    }
}
