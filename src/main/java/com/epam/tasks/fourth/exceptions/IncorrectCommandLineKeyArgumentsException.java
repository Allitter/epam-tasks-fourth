package com.epam.tasks.fourth.exceptions;

public class IncorrectCommandLineKeyArgumentsException extends IncorrectArgumentException {
    public IncorrectCommandLineKeyArgumentsException() {
    }

    public IncorrectCommandLineKeyArgumentsException(String message) {
        super(message);
    }
}
