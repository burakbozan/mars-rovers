package com.n11.rovers.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.n11.rovers.exception.CommandInitializationException;
import com.n11.rovers.exception.OutOfPlateauException;
import com.n11.rovers.exception.PlateauInitializationException;
import com.n11.rovers.exception.RoverNotSetException;
import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;
import com.n11.rovers.models.Plateau;
import com.n11.rovers.models.Rover;
import com.n11.rovers.models.RoverKAFA500;

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
