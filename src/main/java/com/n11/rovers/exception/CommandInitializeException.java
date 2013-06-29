package com.n11.rovers.exception;

public class CommandInitializeException extends Exception{

    private static final long serialVersionUID = 1L;
    public CommandInitializeException() { super(); }
    public CommandInitializeException(String message) { super(message); }
    public CommandInitializeException(String message, Throwable cause) { super(message, cause); }
    public CommandInitializeException(Throwable cause) { super(cause); }
}
