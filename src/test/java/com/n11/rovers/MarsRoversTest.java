package com.n11.rovers;

import java.util.List;

import com.n11.rovers.commands.MarsRover;
import com.n11.rovers.exception.CommandInitializationException;
import com.n11.rovers.exception.OutOfPlateauException;
import com.n11.rovers.exception.PlateauInitializationException;
import com.n11.rovers.exception.RoverNotSetException;

import junit.framework.TestCase;

public class MarsRoversTest 
    extends TestCase
{
    public MarsRoversTest( String testName )
    {
        super( testName );
    }

    public void testMarsRovers() throws PlateauInitializationException,
            RoverNotSetException, OutOfPlateauException, CommandInitializationException
    {
        MarsRover marsRover = new MarsRover(5, 5);
        marsRover.addRover(1, 2, "N");
        marsRover.sendCommand("LMLMLMLMM");
        marsRover.addRover(3, 3, "E");
        marsRover.sendCommand("MMRMMRMRRM");
        
        List<String> positions = marsRover.getFinalPositions();

        assertEquals("1 3 N", positions.get(0));
        assertEquals("5 1 E", positions.get(1));
    }
}
