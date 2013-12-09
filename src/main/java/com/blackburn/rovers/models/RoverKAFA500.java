package com.blackburn.rovers.models;

import com.blackburn.rovers.listener.Listener;

public class RoverKAFA500 extends Rover {

    public RoverKAFA500(Coordinates location, Direction heading) {
        super();
        this.setLocation(location);
        this.setHeading(heading);
    }
    public RoverKAFA500(Coordinates location, Direction heading, Listener plateau) {
        super();
        this.setLocation(location);
        this.setHeading(heading);
        this.addListener(plateau);
    }
}
