package de.lubowiecki.oca.playground.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;

public class NextFileFunctionsTest {

    public static void main(String[] args) {

        Path path = Paths.get("src");

        try {
            // Zeigt den Inhalt eines Ordners
            // Liefert einen Stream zurück
            Files.list(path).forEach(System.out::println);

            // Sucht Ordner-Datei-Strukturen nach Übereinstimmung mit einem Predicate
            // Liefert einen Stream zurück
            BiPredicate<Path, BasicFileAttributes> pred = (p, attrs) -> attrs.lastModifiedTime().to(TimeUnit.MILLISECONDS) > System.currentTimeMillis() - 1000 * 60 * 60 * 24;
            Files.find(path, Integer.MAX_VALUE, pred)
                    //.parallel()
                    .forEach(System.out::println);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
