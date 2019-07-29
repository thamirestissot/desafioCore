package com.thamirestissot.core.desafio.exceptions;

public class NoHasPossibleReadFileConfigurationMessageException extends RuntimeException implements FriendlyMessageException {
    private String nameFile;

    public NoHasPossibleReadFileConfigurationMessageException(String nameFile) {
        super("No has possible read file configuration.");
        this.nameFile = nameFile;
    }

    @Override
    public String getFriendlyMessage() {
        return "Could not read file '" + nameFile + "'.";
    }
}