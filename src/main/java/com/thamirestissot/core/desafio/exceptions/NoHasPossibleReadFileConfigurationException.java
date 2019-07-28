package com.thamirestissot.core.desafio.exceptions;

public class NoHasPossibleReadFileConfigurationException extends RuntimeException implements FriendlyException {
    private String nameFile;
    public NoHasPossibleReadFileConfigurationException(String nameFile) {
        super("No has possible read file configuration.");
        this.nameFile=nameFile;
    }

    @Override
    public String getFriendlyMessage() {
        return "Could not read file '"+nameFile+"'.";
    }
}
