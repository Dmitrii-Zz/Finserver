package ru.finan.finserver.exceptions.model;

public class TrendByNameNotFoundException extends RuntimeException {
    public TrendByNameNotFoundException(final String message) {
        super(message);
    }
}
