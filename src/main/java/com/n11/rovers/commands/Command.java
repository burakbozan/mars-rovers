package com.n11.rovers.commands;

import com.n11.rovers.exception.RoverNotSetException;

public interface Command {
    void execute() throws RoverNotSetException;
}
