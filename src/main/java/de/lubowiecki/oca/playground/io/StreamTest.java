package de.lubowiecki.oca.playground.io;

import java.io.*;
import java.util.logging.FileHandler;

public class StreamTest {

    public static void main(String[] args) {

        File file = new File("test.txt"); // relativer Datei-Pfad

        try {
            OutputStream out = new FileOutputStream(file);
            // out.write('c');
            out.write("Das ist das Haus von Nikigraus!".getBytes()); // getBytes baut aus dem String ein Array von Bytes
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Ab Java 1.7 möglich
        try(OutputStream out = new FileOutputStream(file)) {
            out.write("Das ist das Haus von Nikigraus!".getBytes()); // getBytes baut aus dem String ein Array von Bytes
            // close wird automatisch ausgeführt
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Für Texte nutzt man eher den Reader/Writer
        try(Writer out = new FileWriter(file, true)) { // append: true = Inhalt wird erweitert, standard: Inhalt wird ersetzt
            out.write("Das ist ein anderes Haus von Nikigraus!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Lesen
        try(Reader in = new FileReader(file)) {
            char[] inhalt = new char[100];
            in.read(inhalt);
            System.out.println(inhalt.toString());
            System.out.println(inhalt); // Ausgabe Zeichen für Zeichen
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // hauptsächlich für Binärdaten gedacht
        try(InputStream in = new FileInputStream(file)) {
            int zeichen = 0;
            while((zeichen = in.read()) > 0)
                System.out.print((char)zeichen);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
