package com.exceptions;

public class DatabaseConnectionException extends Exception{

    /**
     * Exeption for when connection to database failed
     * @param message String
     */
    public DatabaseConnectionException(String message) {
        super(message);
    }
}

