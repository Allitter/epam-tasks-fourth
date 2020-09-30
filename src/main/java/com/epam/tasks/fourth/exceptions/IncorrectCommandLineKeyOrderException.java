package com.epam.tasks.fourth.exceptions;

public class IncorrectCommandLineKeyOrderException extends IncorrectArgumentException {
    public IncorrectCommandLineKeyOrderException() {
    }

    public IncorrectCommandLineKeyOrderException(String message) {
        super(message);
    }
}
