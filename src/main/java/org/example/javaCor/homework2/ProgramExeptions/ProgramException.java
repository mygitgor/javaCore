package org.example.javaCor.homework2.ProgramExeptions;

public abstract  class ProgramException extends Exception{
    double argument;

    public ProgramException(String message, double argument) {
        super(message);
        this.argument = argument;
    }
}
