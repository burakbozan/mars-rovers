package com.n11.rovers.exception;

public class CommandInitializationException extends Exception{

    private static final long serialVersionUID = 1L;
    public CommandInitializationException() { super(); }
    public CommandInitializationException(String message) { super(message); }
    public CommandInitializationException(String message, Throwable cause) { super(message, cause); }
    public CommandInitializationException(Throwable cause) { super(cause); }
}
