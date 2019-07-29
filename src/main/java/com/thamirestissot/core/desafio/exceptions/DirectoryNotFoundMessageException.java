package com.thamirestissot.core.desafio.exceptions;

public class DirectoryNotFoundMessageException extends RuntimeException implements FriendlyMessageException {
    private String directoryName;

    public DirectoryNotFoundMessageException(String directoryName) {
        super("Directory not found.");
        this.directoryName = directoryName;
    }

    @Override
    public String getFriendlyMessage() {
        return "Directory not found, please create a directory '" + directoryName + "'";
    }
}