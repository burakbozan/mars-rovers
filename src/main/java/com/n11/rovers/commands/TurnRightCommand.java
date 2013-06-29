package com.n11.rovers.commands;

import com.n11.rovers.exception.RoverNotSetException;

public class TurnRightCommand extends RoverCommand {

	@SuppressWarnings("unused")
	private final static String CODE = "R";

	public void execute() throws RoverNotSetException {
		if(rover == null)
			throw new RoverNotSetException();

		rover.setHeading(rover.getHeading().onLeft().onLeft().onLeft());
	}
}
