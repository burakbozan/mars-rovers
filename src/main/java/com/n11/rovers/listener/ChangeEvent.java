package com.n11.rovers.listener;

import com.n11.rovers.models.Coordinates;

public class ChangeEvent {
	private Object source;
	private Coordinates location;

	public ChangeEvent(Object source, Coordinates location) {
		super();
		this.source = source;
		this.location = location;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public Coordinates getLocation() {
		return location;
	}

	public void setLocation(Coordinates location) {
		this.location = location;
	}
}
