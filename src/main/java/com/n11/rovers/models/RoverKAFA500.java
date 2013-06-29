package com.n11.rovers.models;

import com.n11.rovers.listener.Listener;

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
