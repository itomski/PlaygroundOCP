package de.lubowiecki.oca.playground.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FilesReadContentTest {

    public static void main(String[] args) {

        Path path = Paths.get("test/copies/xyz.txt");

        if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {

            try {

                // readAllLines: liefert eine List. Alle Zeilen werden im Heap abgelegt
                List<String> zeilen = Files.readAllLines(path);
                zeilen.removeIf(z -> z.length() == 0);
                zeilen.forEach(System.out::println);

                System.out.println();

                // Liefert einen Stream. Nur die aktuelle Zeile ist im Speicher
                Stream<String> zeilenStr = Files.lines(path);
                zeilenStr.filter(z -> z.length() > 0).forEach(System.out::println);



            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Datei nicht verfügbar!");
        }

    }

}
