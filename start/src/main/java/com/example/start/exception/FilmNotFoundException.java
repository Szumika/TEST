package com.example.start.exception;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String msg) {
        super(msg);
    }
}
