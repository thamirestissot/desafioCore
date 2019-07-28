package com.thamirestissot.core.desafio;

import com.thamirestissot.core.desafio.exceptions.DirectoryNotFoundException;
import com.thamirestissot.core.desafio.exceptions.NoHasPossibleReadFileConfigurationException;
import com.thamirestissot.core.desafio.manipulateFiles.HandlerFile;
import com.thamirestissot.core.desafio.manipulateFiles.Watcher;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            HandlerFile handlerFile=new HandlerFile();
            List<String> fileNames = handlerFile.readDirectory();
            fileNames.stream().forEach(s -> handlerFile.processFile(s));
        } catch (DirectoryNotFoundException | NoHasPossibleReadFileConfigurationException e) {
            System.out.println(e.getFriendlyMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Watcher watcher= new Watcher();
        try {
            watcher.watch();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}