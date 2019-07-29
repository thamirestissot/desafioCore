package com.thamirestissot.core.desafio.exceptions;

public class InfoCodeNotRegisteredMessageException extends RuntimeException implements FriendlyMessageException {
    public InfoCodeNotRegisteredMessageException() {
        super("Info code not registered.");
    }

    @Override
    public String getFriendlyMessage() {
        return "There is an unregistered data info code.";
    }
}