package com.thamirestissot.core.desafio;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class Watcher {
    public void monitora(String pasta) throws IOException, InterruptedException {
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path path = Paths.get(System.getProperty("user.home")+pasta);

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE/*,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY*/
        );
        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(
                        "Event kind:" + event.kind()
                                + ". File affected: " + event.context() + ".");
                  //  HandlerFile.readFile(System.getProperty("user.home")+pasta+"/"+event.context());
            }
            watchKey.reset();

        }
    }
}
