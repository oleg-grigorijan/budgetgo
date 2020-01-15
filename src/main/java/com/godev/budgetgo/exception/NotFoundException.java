package com.godev.budgetgo.exception;

public class NotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Not found";

    public NotFoundException() {
        this(DEFAULT_MESSAGE);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
