package de.lubowiecki.oca.playground.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.*;

public class PathTest {

    public static void main(String[] args) {

        Path p1 = Paths.get("test", "abc", "xyz.txt"); // relativ

        Path p2 = Paths.get("."); // aktuelles Verzeichnis

        // bewegung 2 Verzeichnisse
        Path p3 = Paths.get("../../"); // aktuelles Verzeichnis verlassen

        // Absolute Pfade
        p1 = Paths.get("/"); // Linux / Unix / MacOS
        p1 = Paths.get("C:\\"); // Win

        System.out.println(p3);
        System.out.println(p3.toAbsolutePath());
        System.out.println(p3.toAbsolutePath().normalize());

        p3 = FileSystems.getDefault().getPath("test.txt");
        System.out.println(p3);
        System.out.println(p3.toAbsolutePath());

        System.out.println();
        FileSystem sys = FileSystems.getDefault();
        System.out.println(sys.supportedFileAttributeViews());

        System.out.println();

        // Laufwerke
        sys.getFileStores().forEach(System.out::println);

        System.out.println("---------- METHODEN VON PATH -------------");

        p1 = Paths.get("src/main/java");
        p2 = Paths.get("de/lubowiecki/oca/playground/nio");


        System.out.println(p1);
        System.out.println(p2);
        Path p4 = p1.resolve(p2);
        System.out.println(p4); // Verbindet die Pfade
        System.out.println(p4.toAbsolutePath()); // Gibt einen absoluten Pfad (Prüft nicht die Verfügbarkeit)

        // ist der zweite Parameter ein absoluter Pfad, ist das Ergebnis gleich dem zweiten Parameter

        try {
            System.out.println(p4.toRealPath()); // Prüft verfügbarkeit der Datei
        }
        catch (IOException e) { // Exception, wenn nicht verfügbar
            e.printStackTrace();
        }

        System.out.println();

        p4 = p1.resolveSibling(p2); // Verbindet die Ordner als Geschwister
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p4);

        System.out.println();

        p4 = p1.relativize(p2); // gibt den relativen Pfad von p1 zu p2
        System.out.println(p4);

        // Releative und absolute Pfade sollten nicht gemischt werden
        p1 = Paths.get("/");
        //p4 = p1.relativize(p2); // IllegalArgumentException: absolut und relativ gemischt
        //System.out.println(p4);

        System.out.println();

        p4 = p1.resolve(p2);
        System.out.println(p4);
        System.out.println(p4.getNameCount()); // Root ist nicht enthalten
        System.out.println(p4.getRoot()); // Root (unter Win der Laufwerk-Buchstabe)
        System.out.println(p4.getName(3)); // gibt den Namen am index
        System.out.println(p4.getParent()); // gibt das Eltern-Element
        System.out.println(p4.getParent().getParent()); // gibt das Eltern-Element
        System.out.println(p4.getFileName()); // gibt das letzte Element

        System.out.println();

        File f = new File("data.txt");
        p1 = f.toPath(); // File wird in Path konvertiert
        f = p1.toFile(); // Path wird in File konvertiert

        System.out.println(p4.subpath(1,3));

        p1 = Path.of("test/copies/xyz.txt");

    try {
            BufferedReader in = Files.newBufferedReader(p1, Charset.forName("UTF-8"));
            // in.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
