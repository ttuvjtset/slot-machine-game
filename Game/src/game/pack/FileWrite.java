package game.pack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;


public class FileWrite {

    private BufferedWriter out;

    public FileWrite(String filename) {
        try {
            out = new BufferedWriter(new FileWriter(filename));
        } catch (NoSuchFileException e) {
            System.out.println("No such file");
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeData(String data) {
        try {
            out.write(data);
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
