package com.n11.rovers;

import com.blackburn.rovers.commands.CommandFactory;
import com.blackburn.rovers.commands.RoverCommand;
import com.blackburn.rovers.exception.CommandInitializationException;
import com.blackburn.rovers.exception.RoverNotSetException;
import com.blackburn.rovers.models.Coordinates;
import com.blackburn.rovers.models.Direction;
import com.blackburn.rovers.models.Rover;
import com.blackburn.rovers.models.RoverKAFA500;

import junit.framework.TestCase;

public class CommandTest extends TestCase
{

    public CommandTest( String testName )
    {
        super( testName );
    }

    public void testCommandFactoryGetCommand() throws CommandInitializationException
    {
        assertNotNull(CommandFactory.createCommand("L"));
        assertNotNull(CommandFactory.createCommand("R"));
        assertNotNull(CommandFactory.createCommand("M"));
    }

    //TODO use @Before for initializing rover
    public void testTurnLeftCommand() throws CommandInitializationException, RoverNotSetException
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        RoverCommand turnLeftCommand = (RoverCommand) CommandFactory.createCommand("L");

        turnLeftCommand.setRover(rover);
        turnLeftCommand.execute();

        assertEquals(Direction.WEST, rover.getHeading());
    }

    //TODO use @Before for initializing rover
    public void testTurnRightCommand() throws CommandInitializationException, RoverNotSetException
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        RoverCommand turnLeftCommand = (RoverCommand) CommandFactory.createCommand("R");

        turnLeftCommand.setRover(rover);
        turnLeftCommand.execute();

        assertEquals(Direction.EAST, rover.getHeading());
    }

    //TODO use @Before for initializing rover
    public void testMoveForwardCommand() throws CommandInitializationException, RoverNotSetException
    {
        Rover rover = new RoverKAFA500(new Coordinates(0, 0), Direction.NORTH);
        RoverCommand turnLeftCommand = (RoverCommand) CommandFactory.createCommand("M");

        turnLeftCommand.setRover(rover);
        turnLeftCommand.execute();

        assertEquals(new Coordinates(0, 1), rover.getLocation());
    }
}
