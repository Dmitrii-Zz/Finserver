package ru.finan.finserver.exceptions.model;

public class CategoryByNameNotFoundException extends RuntimeException {
    public CategoryByNameNotFoundException(final String message) {
        super(message);
    }
}
