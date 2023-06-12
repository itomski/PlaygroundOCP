package de.lubowiecki.oca.playground.io;

import java.io.File;
import java.io.IOException;

public class Start {

    public static void main(String[] args) {

        // OutputStream: Console
        // System.out
        // System.err

        // InputStream: Console
        // System.in

        // System.err.print("Hallo");
        // System.out.print("Hallo");

        File file = new File("test.txt"); // relativ zu dem Ablageort des Projektes
        //file = new File("c:\\test"); // absoluter Pfad (WIN)
        //file = new File("/test"); // absoluter Pfad (Mac/Linux/Unix)
        File dir = new File("test"); // absoluter Pfad (Mac/Linux/Unix)

        File subDir = new File(dir, "abc"); // Unterordner

        // Fast alle Methoden im IO/NIO können eine IOException produzieren

        try {
            if(!file.exists())
                file.createNewFile(); // Baut ein File

            if(!dir.exists())
                dir.mkdir(); // Baut ein Directory

            if(!subDir.exists()) {
                subDir.mkdir();
                // subDir.mkdirs(); // Baut alle nötigen Verzeichnisse!
            }

            System.out.println("Execute: " + file.canExecute());
            System.out.println("Read: " + file.canRead());
            System.out.println("Write: " + file.canWrite());
            System.out.println("File: " + file.isFile());
            System.out.println("Dir: " + file.isDirectory());
            System.out.println("Absoluter Pfad: " + file.getAbsolutePath());
            System.out.println("Relativer Pfad: " + file);
            System.out.println("Geändert: " + file.lastModified());
            System.out.println("Freier Speicher: " + file.getFreeSpace());
            System.out.println("Nutzbarer Speicher: " + file.getUsableSpace());
            System.out.println("Gesamt Speicher: " + file.getTotalSpace());
            System.out.println("Eltern Element: " + file.getAbsoluteFile().getParent());

            file.delete(); // Sofort löschen
            // file.deleteOnExit(); // Löschen beim Verlassen des Programms
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
