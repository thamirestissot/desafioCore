package com.thamirestissot.core.desafio;

import java.io.IOException;
import java.nio.file.*;

public class Watcher {
    public void watch() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        HandlerFile handlerFile = new HandlerFile();
        Path path = Paths.get(handlerFile.getINPATH());
        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );
        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if (String.valueOf(event.context()).contains(".dat")) {
                    handlerFile.processFile(String.valueOf(event.context()));
                }
                watchKey.reset();
            }
        }
    }
}
