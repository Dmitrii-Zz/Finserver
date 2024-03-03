package ru.finan.finserver.exceptions.model;

public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException(final String message) {
        super(message);
    }
}
