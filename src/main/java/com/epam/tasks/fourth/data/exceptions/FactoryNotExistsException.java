package com.epam.tasks.fourth.data.exceptions;

import com.epam.tasks.fourth.exceptions.IncorrectArgumentException;

public class FactoryNotExistsException extends IncorrectArgumentException {

    public FactoryNotExistsException() {
        super("Factory Not Exists");
    }

    public FactoryNotExistsException(String message) {
        super(message);
    }
}
