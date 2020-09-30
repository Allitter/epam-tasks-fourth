package com.epam.tasks.fourth.exceptions;

public class IncorrectCommandLineKeyException extends IncorrectArgumentException {
    public IncorrectCommandLineKeyException() {
    }

    public IncorrectCommandLineKeyException(String message) {
        super(message);
    }
}
