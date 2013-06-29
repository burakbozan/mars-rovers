package com.n11.rovers.exception;

public class RoverNotSetException extends Exception{

    private static final long serialVersionUID = 1L;

    public RoverNotSetException() { super(); }
    public RoverNotSetException(String message) { super(message); }
    public RoverNotSetException(String message, Throwable cause) { super(message, cause); }
    public RoverNotSetException(Throwable cause) { super(cause); }
}
