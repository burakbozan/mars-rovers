package com.n11.rovers.commands;

import com.n11.rovers.models.Rover;

abstract public class RoverCommand implements Command{

    protected Rover rover;

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
