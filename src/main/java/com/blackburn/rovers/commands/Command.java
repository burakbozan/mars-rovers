package com.blackburn.rovers.commands;

import com.blackburn.rovers.exception.RoverNotSetException;

public interface Command {
    void execute() throws RoverNotSetException;
}
