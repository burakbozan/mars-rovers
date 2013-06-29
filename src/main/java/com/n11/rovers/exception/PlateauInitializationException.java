package com.n11.rovers.exception;

public class PlateauInitializationException extends Exception{

    private static final long serialVersionUID = 1L;
    public PlateauInitializationException() { super(); }
    public PlateauInitializationException(String message) { super(message); }
    public PlateauInitializationException(String message, Throwable cause) { super(message, cause); }
    public PlateauInitializationException(Throwable cause) { super(cause); }
}
