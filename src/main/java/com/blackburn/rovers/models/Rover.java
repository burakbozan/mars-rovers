package com.blackburn.rovers.models;

import java.util.ArrayList;
import java.util.List;

import com.blackburn.rovers.commands.RoverCommand;
import com.blackburn.rovers.exception.OutOfPlateauException;
import com.blackburn.rovers.exception.RoverNotSetException;
import com.blackburn.rovers.listener.ChangeEvent;
import com.blackburn.rovers.listener.Listener;

public abstract class Rover {

    private Coordinates location;
    private Direction heading;
    private List<Listener> listeners = new ArrayList<Listener>();

    public void execute(RoverCommand command) throws RoverNotSetException, OutOfPlateauException {
        command.setRover(this);
        command.execute();
        notifyListeners(this.getLocation());
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

    public String displayPosition() {
        return location.getX() + " " + location.getY() + " " + heading.getDirectionCode();
    }

    private void notifyListeners(Coordinates location) throws OutOfPlateauException {
        for (Listener listener : listeners) {
          listener.change(new ChangeEvent(this, location));
        }
    }

    public void addListener(Listener newListener) {
        listeners.add(newListener);
    }
}
