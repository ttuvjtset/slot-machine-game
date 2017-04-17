package game.pack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Writing to the file with Bufferedwriter.
 */
public class FileWrite {
    /**
     * BufferedWriter.
     */
    private BufferedWriter out;

    /**
     * Constructor for initialisation.
     *
     * @param filename filename.
     */
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

    /**
     * Writing data to the file.
     *
     * @param data data string.
     */
    public void writeData(String data) {
        try {
            out.write(data);
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Close FileWriter.
     */
    public void close() {
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
