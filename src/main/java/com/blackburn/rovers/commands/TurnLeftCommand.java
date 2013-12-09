package com.blackburn.rovers.commands;

import com.blackburn.rovers.exception.RoverNotSetException;

public class TurnLeftCommand extends RoverCommand {

    @SuppressWarnings("unused")
    private final static String CODE = "L";

    public void execute() throws RoverNotSetException {
        if(rover == null)
            throw new RoverNotSetException();

        rover.setHeading(rover.getHeading().onLeft());
    }
}
