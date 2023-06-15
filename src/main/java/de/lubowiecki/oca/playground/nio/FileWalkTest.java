package de.lubowiecki.oca.playground.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

public class FileWalkTest {

    public static void main(String[] args) {

        Path path = Paths.get("src");

        try {
            Files.walk(path)
                    .filter(p -> p.getFileName().toString().endsWith(".java"))
                    .limit(10)
                    .forEach(System.out::println);

            System.out.println();


            // Interface FileVisitor: 4 Methoden müssen implementiert werden
            FileVisitor<Path> visitor = new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Startet Besuch: " + dir + " " + attrs.lastAccessTime());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Besuch: " + file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.out.println("Fehler!");
                    return FileVisitResult.TERMINATE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("Ende Besuch: " + dir);
                    return FileVisitResult.CONTINUE;
                }
            };

            // Es können die Methoden überschrieben werden, die man anpassen will
            visitor = new SimpleFileVisitor<Path>() { // Einfache Implementierung des FileVisitors

                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Startet Besuch: " + dir + " " + attrs.lastAccessTime());
                    return FileVisitResult.CONTINUE;
                }
            };

            //Files.walkFileTree(path, visitor);
            Files.walkFileTree(path, Set.of(FileVisitOption.FOLLOW_LINKS), 3, visitor);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
}
