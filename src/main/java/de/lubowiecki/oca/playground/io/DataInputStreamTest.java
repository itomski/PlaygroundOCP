package de.lubowiecki.oca.playground.io;

import java.io.*;

public class DataInputStreamTest {

    private static final String FILE_NAME = "count.txt";

    public static void main(String[] args) {
        new DataInputStreamTest().start();
    }

    private void start() {

        try {
            int i = load();

            System.out.println(i);
            i++;
            System.out.println(i);

            save(i);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int load() throws IOException {

        /*
        try(Reader in = new FileReader(FILE_NAME)) {
            return in.read();
        }
        */

        try(DataInputStream in = new DataInputStream(new FileInputStream(FILE_NAME))) {
            return in.readInt();
        }
        catch (EOFException e) {
            return 0;
        }
    }

    private void save(int i) throws IOException {

        /*
        try(Writer out = new FileWriter(FILE_NAME)) {
            out.write(i);
        }
        */

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeInt(i);
        }
    }
}
