package com.n11.rovers.models;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH("N") {
        public Direction onLeft() {
            return WEST;
        }

        public Coordinates onForward() {
            return new Coordinates(0, 1);
        }
    },
    SOUTH("S") {
        public Direction onLeft() {
            return EAST;
        }

        public Coordinates onForward() {
            return new Coordinates(0, -1);
        }
    },
    WEST("W") {
        public Direction onLeft() {
            return SOUTH;
        }

        public Coordinates onForward() {
            return new Coordinates(-1, 0);
        }
    },
    EAST("E") {
        public Direction onLeft() {
            return NORTH;
        }

        public Coordinates onForward() {
            return new Coordinates(1, 0);
        }
    };

    private final String directionCode;
    private static final Map<String, Direction> lookup = new HashMap<String, Direction>();
    static {
        for(Direction d: Direction.values())
            lookup.put(d.getDirectionCode(), d);
    }

    private Direction(String directionCode) {
        this.directionCode = directionCode;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public static Direction get(String directionCode) {
        return lookup.get(directionCode);
    }

    public abstract Direction onLeft();
    public abstract Coordinates onForward();
}
