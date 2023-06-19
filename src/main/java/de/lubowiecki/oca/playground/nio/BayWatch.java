package de.lubowiecki.oca.playground.nio;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class BayWatch {

    public static void main(String[] args) {

        Path path = Paths.get(System.getProperty("user.home"), "/io");

        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();

            // Es werden für den vorgegebenen Pfad folgende Events beobachtet
            path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            WatchKey key;
            while((key = watcher.take()) != null) {
                for(WatchEvent event : key.pollEvents()) {
                    System.out.println(event.kind() + ": " + event.context());
                }
                key.reset();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
