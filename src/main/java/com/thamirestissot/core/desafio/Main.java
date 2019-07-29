package com.thamirestissot.core.desafio;

import com.thamirestissot.core.desafio.exceptions.DirectoryNotFoundMessageException;
import com.thamirestissot.core.desafio.exceptions.NoHasPossibleReadFileConfigurationMessageException;
import com.thamirestissot.core.desafio.manipulateFiles.HandlerFile;
import com.thamirestissot.core.desafio.manipulateFiles.Watcher;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            HandlerFile handlerFile = new HandlerFile();
            List<String> fileNames = handlerFile.readDirectory();
            fileNames.stream().forEach(s -> handlerFile.processFile(s));
            Watcher watcher = new Watcher();
            try {
                watcher.watch();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (DirectoryNotFoundMessageException | NoHasPossibleReadFileConfigurationMessageException e) {
            System.out.println(e.getFriendlyMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}