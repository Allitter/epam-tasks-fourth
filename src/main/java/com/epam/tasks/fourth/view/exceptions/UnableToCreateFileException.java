package com.epam.tasks.fourth.view.exceptions;

import java.io.IOException;

public class UnableToCreateFileException extends IOException {
    public UnableToCreateFileException() {
    }

    public UnableToCreateFileException(String message) {
        super(message);
    }
}
