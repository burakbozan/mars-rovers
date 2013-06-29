package com.n11.rovers;

import com.n11.rovers.commands.Command;
import com.n11.rovers.commands.CommandFactory;
import com.n11.rovers.commands.RoverCommand;
import com.n11.rovers.exception.CommandInitializeException;
import com.n11.rovers.exception.RoverNotSetException;
import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;
import com.n11.rovers.models.Rover;
import com.n11.rovers.models.RoverKAFA500;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CommandTest extends TestCase
{

    public CommandTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( CommandTest.class );
    }

    public void testCommandFactoryGetCommand() throws CommandInitializeException
    {
        assertNotNull(CommandFactory.createCommand("L"));
        assertNotNull(CommandFactory.createCommand("R"));
        assertNotNull(CommandFactory.createCommand("M"));
    }

    //TODO use @Before for initializing rover
    public void testTurnLeftCommand() throws CommandInitializeException, RoverNotSetException
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        RoverCommand turnLeftCommand = (RoverCommand) CommandFactory.createCommand("L");

        turnLeftCommand.setRover(rover);
        turnLeftCommand.execute();

        assertEquals(Direction.WEST, rover.getHeading());
    }

    //TODO use @Before for initializing rover
    public void testTurnRightCommand() throws CommandInitializeException, RoverNotSetException
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        RoverCommand turnLeftCommand = (RoverCommand) CommandFactory.createCommand("R");

        turnLeftCommand.setRover(rover);
        turnLeftCommand.execute();

        assertEquals(Direction.EAST, rover.getHeading());
    }

    //TODO use @Before for initializing rover
    public void testMoveForwardCommand() throws CommandInitializeException, RoverNotSetException
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        RoverCommand turnLeftCommand = (RoverCommand) CommandFactory.createCommand("M");

        turnLeftCommand.setRover(rover);
        turnLeftCommand.execute();

        assertEquals(new Coordinates(0, 1), rover.getLocation());
    }
}
