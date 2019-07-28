package com.thamirestissot.core.desafio.exceptions;

public class DirectoryNotFoundException extends RuntimeException implements FriendlyException {
    private String directoryName;
    public DirectoryNotFoundException(String directoryName) {
        super("Directory not found.");
        this.directoryName=directoryName;
    }

    @Override
    public String getFriendlyMessage() {
        return "Directory not found, please create a directory '"+directoryName+"'";
    }
}