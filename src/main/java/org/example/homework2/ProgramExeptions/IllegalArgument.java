package org.example.homework2.ProgramExeptions;

public class IllegalArgument extends ProgramException{
    public IllegalArgument(String message, double argument) {
        super(message, argument);
    }
}
