package com.emysilva.fleet.management.application.exception;

public class NoSuchDataException extends RuntimeException {
    public NoSuchDataException(String message) {
        super(message);
    }
    public NoSuchDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
