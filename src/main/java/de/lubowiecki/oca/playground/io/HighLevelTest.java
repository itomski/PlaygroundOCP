package de.lubowiecki.oca.playground.io;

import com.google.protobuf.compiler.PluginProtos;

import java.io.*;

public class HighLevelTest {

    public static void main(String[] args) {

        /*
        try {
            // LowLevel (Lesen)
            FileInputStream in1 = new FileInputStream("test.txt");
            FileReader in2 = new FileReader("test.txt");

            // LowLevel (Schreiben)
            FileOutputStream out1 = new FileOutputStream("test.txt");
            FileWriter out2 = new FileWriter("test.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */


        // HighLevel: BufferedReader (Basiert auf dem LowLevel)
        try(FileReader in = new FileReader("test.txt");
                BufferedReader bIn = new BufferedReader(in)) {

            String line = null;
            while((line = bIn.readLine()) != null)
                System.out.println(line);

            // close wird in umgekehrter Reihenfolge auf den Resourcen ausgeführt d.h.
            // zuerst auf bIn
            // danach auf in
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // HighLevel: BufferedReader (Basiert auf dem LowLevel)
        try(BufferedWriter out = new BufferedWriter(new FileWriter("test.txt", true))) {
            out.write("Das ist ja was...");
            out.newLine();
            out.write("Das ist ja was anderes...");

            // close wird auch an den LowLevel-Writer weitergegeben
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
