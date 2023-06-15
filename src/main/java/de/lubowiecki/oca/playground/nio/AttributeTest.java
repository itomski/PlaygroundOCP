package de.lubowiecki.oca.playground.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.Map;

public class AttributeTest {

    public static void main(String[] args) {

        Path path = Paths.get("test/copies/xyz.txt");

        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isSymbolicLink(path));

        try {
            Files.setLastModifiedTime(path, FileTime.from(Instant.now()));

            System.out.println(Files.getOwner(path));
            // UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("pparker");
            // Files.setOwner(path, user);

            BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            BasicFileAttributes attrs = view.readAttributes();
            System.out.println(attrs.creationTime());
            System.out.println(attrs.lastAccessTime());
            System.out.println(attrs.lastModifiedTime());

            System.out.println();

            PosixFileAttributeView posixView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
            PosixFileAttributes posixAttrs = posixView.readAttributes();
            System.out.println(posixAttrs.group());

            System.out.println();

            /*
            DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
            DosFileAttributes dosAttrs = dosView.readAttributes();
            System.out.println(dosAttrs.isArchive());
            */

            // Etwas kürzer
            posixAttrs = Files.readAttributes(path, PosixFileAttributes.class);

            // Direkt zugriff auf Attribute
            Map<String, Object> attrMap = Files.readAttributes(path, "unix:*"); // Liest alle Attribute einer Gruppe
            System.out.println(attrMap);
            System.out.println(attrMap.get("group"));
            System.out.println(Files.getAttribute(path, "unix:group")); // Liest ein Attribut

            System.out.println();

            System.out.println(System.getProperties()); // Properties der JRE
            System.out.println(System.getProperty("user.home")); // Fragt das Benutzerverzeichniss ab

            System.out.println();

            System.getProperties().keySet().stream().forEach(System.out::println);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
