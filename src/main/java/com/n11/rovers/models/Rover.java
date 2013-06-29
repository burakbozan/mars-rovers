package com.n11.rovers.models;

import com.n11.rovers.commands.Command;
import com.n11.rovers.exception.RoverNotSetException;

public abstract class Rover {

    private Coordinates location;
    private Direction heading;

    public void execute(Command command) throws RoverNotSetException {
        command.execute();
    }

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    public Direction getHeading() {
        return heading;
    }

    public void setHeading(Direction heading) {
        this.heading = heading;
    }
}
