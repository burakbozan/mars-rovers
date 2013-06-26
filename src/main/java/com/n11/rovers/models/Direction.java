package com.n11.rovers.models;

public enum Direction {

    NORTH("N") {
        public Direction onLeft() {
            return WEST;
        }
    },
    SOUTH("S") {
        public Direction onLeft() {
            return EAST;
        }
    },
    WEST("W") {
        public Direction onLeft() {
            return SOUTH;
        }
    },
    EAST("E") {
        public Direction onLeft() {
            return NORTH;
        }
    };

    private String directionCode;

    private Direction(String directionCode) {
        this.directionCode = directionCode;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public Direction onLeft() {
        return this;
    }
}
