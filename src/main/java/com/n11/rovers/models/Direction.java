package com.n11.rovers.models;

public enum Direction {

    NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

    private String directionCode;

    private Direction(String directionCode) {
        this.directionCode = directionCode;
    }

    public String getDirectionCode() {
        return directionCode;
    }
}
