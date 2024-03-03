package ru.finan.finserver.exceptions.model;

public class PasswordException extends RuntimeException {
    public PasswordException(final String message) {
        super(message);
    }
}
