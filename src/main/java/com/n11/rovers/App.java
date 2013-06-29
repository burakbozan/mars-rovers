package com.n11.rovers;

import com.n11.rovers.commands.CommandFactory;
import com.n11.rovers.exception.CommandInitializationException;
import com.n11.rovers.exception.OutOfPlateauException;
import com.n11.rovers.exception.PlateauInitializationException;
import com.n11.rovers.exception.RoverNotSetException;
import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;
import com.n11.rovers.models.Plateau;
import com.n11.rovers.models.Rover;
import com.n11.rovers.models.RoverKAFA500;

/**
 * Mars-Rovers
 *
 */
public class App 
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

        Plateau plateau = new Plateau(new Coordinates(5, 5));
        Rover rover = new RoverKAFA500(new Coordinates(1, 2), Direction.get("N"), plateau);

        rover.execute(CommandFactory.createCommand("L"));
        rover.execute(CommandFactory.createCommand("M"));
        rover.execute(CommandFactory.createCommand("L"));
        rover.execute(CommandFactory.createCommand("M"));
        rover.execute(CommandFactory.createCommand("L"));
        rover.execute(CommandFactory.createCommand("M"));
        rover.execute(CommandFactory.createCommand("L"));
        rover.execute(CommandFactory.createCommand("M"));
        rover.execute(CommandFactory.createCommand("M"));

        System.out.println(rover.displayPosition());

        Rover rover2 = new RoverKAFA500(new Coordinates(3, 3), Direction.get("E"), plateau);

        rover2.execute(CommandFactory.createCommand("M"));
        rover2.execute(CommandFactory.createCommand("M"));
        rover2.execute(CommandFactory.createCommand("R"));
        rover2.execute(CommandFactory.createCommand("M"));
        rover2.execute(CommandFactory.createCommand("M"));
        rover2.execute(CommandFactory.createCommand("R"));
        rover2.execute(CommandFactory.createCommand("M"));
        rover2.execute(CommandFactory.createCommand("R"));
        rover2.execute(CommandFactory.createCommand("R"));
        rover2.execute(CommandFactory.createCommand("M"));

        System.out.println(rover2.displayPosition());
        System.out.println("===========");
    }
}
