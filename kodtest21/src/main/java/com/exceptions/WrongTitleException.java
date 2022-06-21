package com.exceptions;

public class WrongTitleException extends Exception{

    /**
     * Exception for when the title is wrong
     * @param message
     */
    public WrongTitleException(String message) {
        super(message);
    }
}
