package com.blackburn.rovers.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.blackburn.rovers.exception.CommandInitializationException;
import com.blackburn.rovers.exception.OutOfPlateauException;
import com.blackburn.rovers.exception.PlateauInitializationException;
import com.blackburn.rovers.exception.RoverNotSetException;
import com.blackburn.rovers.models.Coordinates;
import com.blackburn.rovers.models.Direction;
import com.blackburn.rovers.models.Plateau;
import com.blackburn.rovers.models.Rover;
import com.blackburn.rovers.models.RoverKAFA500;

public class MarsRover {

    private List<Rover> rovers = new ArrayList<Rover>();
    private Plateau plateau;
    private int sentCommand = 0;

    public MarsRover(int maxXCoord, int maxYCoord) throws PlateauInitializationException {
        super();
        this.plateau = new Plateau(new Coordinates(maxXCoord, maxYCoord));
    }

    public void addRover(int x, int y, String heading) {
        Rover rover = new RoverKAFA500(new Coordinates(x, y), Direction.get(heading), this.plateau);
        this.rovers.add(rover);
    }

    public void sendCommand(String commands) throws RoverNotSetException, OutOfPlateauException, CommandInitializationException {
        Rover rover = rovers.get(sentCommand++);

        String [] commandsArr = commands.split("(?!^)");

        for (int i = 0; i < commandsArr.length; i++) {
            String strCommand = commandsArr[i];
            rover.execute(CommandFactory.createCommand(strCommand));
        }
    }

    public List<String> getFinalPositions() {
        List<String> positions = new ArrayList<String>();
        for (Iterator<Rover> iterator = this.rovers.iterator(); iterator.hasNext();) {
            Rover rover = (Rover) iterator.next();
            positions.add(rover.displayPosition());
        }
        return positions;
    }
}
