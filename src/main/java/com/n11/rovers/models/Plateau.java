package com.n11.rovers.models;

public class Plateau {

	private Coordinates maxCoordinates;

	public Plateau(Coordinates maxCoordinates) {
		super();
		this.maxCoordinates = maxCoordinates;
	}

	public Coordinates getMaxCoordinates() {
		return maxCoordinates;
	}

	public void setMaxCoordinates(Coordinates maxCoordinates) {
		this.maxCoordinates = maxCoordinates;
	}
}
