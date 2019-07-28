package com.thamirestissot.core.desafio.exceptions;

public class InfoCodeNotRegisteredException extends RuntimeException implements FriendlyException {
    public InfoCodeNotRegisteredException() {
        super("Info code not registered.");
    }

    @Override
    public String getFriendlyMessage() {
        return "There is an unregistered data info code.";
    }
}
