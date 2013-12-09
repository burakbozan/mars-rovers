package com.blackburn.rovers.commands;

import com.blackburn.rovers.models.Rover;

abstract public class RoverCommand implements Command{

    protected Rover rover;

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
