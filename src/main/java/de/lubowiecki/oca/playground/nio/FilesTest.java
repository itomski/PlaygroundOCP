package de.lubowiecki.oca.playground.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesTest {

    public static void main(String[] args) {

        Path pfad = Paths.get("test", "abc", "xyz.txt");
        //Path pfad = Paths.get("test/abc", "xyz.txt");
        //Path pfad = Paths.get("test/abc/xyz.txt");

        try {

            if(!Files.exists(pfad.getParent()))
                Files.createDirectories(pfad.getParent()); // Erzeugt alle Verzeichnisse
                // Files.createDirectory(pfad.getParent()); // Erzeugt ein Verzeichnis

            if(!Files.exists(pfad))
                Files.createFile(pfad);

            System.out.println();

            Path absolut = pfad.toAbsolutePath();
            System.out.println(pfad);
            System.out.println(absolut);
            System.out.println(Files.isSameFile(pfad, absolut)); // Prüft, ob die Pfade auf die gleiche Stelle zeigen

            System.out.println();

            // Standard: Beim Kopieren werden die Attribute neu belegt
            // StandardCopyOption.COPY_ATTRIBUTES kopiert die Attribute mit der Datei

            //Files.copy(pfad, Paths.get("test/abc/xyz_copy.txt")); // Überschreibt keine vorhandenen Dateien
            Files.copy(pfad, Paths.get("test/abc/xyz_copy.txt"), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES); // Überschreibt vorhandene Dateien

            // Datei bewegen
            // Standard: Beim Bewegen werden die Attribute mit beweget
            // StandardCopyOption.ATOMIC_MOVE: Die Bewegung wird als eine nicht unterbrechbare Aktion ausgeführt
            Files.move(pfad, Paths.get("test/copies", pfad.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
