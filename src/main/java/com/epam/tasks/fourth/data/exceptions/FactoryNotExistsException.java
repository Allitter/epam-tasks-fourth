package com.epam.tasks.fourth.data.exceptions;

public class FactoryNotExistsException extends Exception {
    public FactoryNotExistsException() {
    }

    public FactoryNotExistsException(String message) {
        super(message);
    }

    public FactoryNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactoryNotExistsException(Throwable cause) {
        super(cause);
    }
}
