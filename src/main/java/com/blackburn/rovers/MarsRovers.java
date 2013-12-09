package com.blackburn.rovers;

import java.util.Iterator;
import java.util.List;

import com.blackburn.rovers.commands.CommandFactory;
import com.blackburn.rovers.commands.MarsRover;
import com.blackburn.rovers.exception.CommandInitializationException;
import com.blackburn.rovers.exception.OutOfPlateauException;
import com.blackburn.rovers.exception.PlateauInitializationException;
import com.blackburn.rovers.exception.RoverNotSetException;
import com.blackburn.rovers.models.Coordinates;
import com.blackburn.rovers.models.Direction;
import com.blackburn.rovers.models.Plateau;
import com.blackburn.rovers.models.Rover;
import com.blackburn.rovers.models.RoverKAFA500;

/**
 * Mars-Rovers
 *
 */
public class MarsRovers
{
    public static void main( String[] args ) throws RoverNotSetException,
        OutOfPlateauException, CommandInitializationException, PlateauInitializationException
    {
        System.out.println("===========");
        System.out.println("Test Input:");
        System.out.println("5 5");
        System.out.println("1 2 N");
        System.out.println("LMLMLMLMM");
        System.out.println("3 3 E");
        System.out.println("MMRMMRMRRM");

        System.out.println("Expected Output:");

        MarsRover marsRover = new MarsRover(5, 5);
        marsRover.addRover(1, 2, "N");
        marsRover.sendCommand("LMLMLMLMM");
        marsRover.addRover(3, 3, "E");
        marsRover.sendCommand("MMRMMRMRRM");

        List<String> positions = marsRover.getFinalPositions();

        for (Iterator<String> iterator = positions.iterator(); iterator.hasNext();) {
			String position = (String) iterator.next();
			System.out.println(position);
		}
        System.out.println("===========");
    }
}
