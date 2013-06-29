package com.n11.rovers.commands;

import com.n11.rovers.exception.RoverNotSetException;

public class MoveForwardCommand extends RoverCommand {

    @SuppressWarnings("unused")
    private final static String CODE = "M";

    public void execute() throws RoverNotSetException {
        if(rover == null)
            throw new RoverNotSetException();

        rover.setLocation(rover.getLocation().goOn(rover.getHeading()));
    }
}
