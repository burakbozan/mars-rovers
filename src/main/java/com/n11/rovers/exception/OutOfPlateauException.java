package com.n11.rovers.exception;

public class OutOfPlateauException extends Exception{

    private static final long serialVersionUID = 1L;
    public OutOfPlateauException() { super(); }
    public OutOfPlateauException(String message) { super(message); }
    public OutOfPlateauException(String message, Throwable cause) { super(message, cause); }
    public OutOfPlateauException(Throwable cause) { super(cause); }
}
