package game.pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * FileRead.
 */
public class FileRead {

    /**
     * line.
     */
    String line;

    /**
     * BufferedReader.
     */
    private BufferedReader reader;

    /**
     * Constructor for initialisation.
     *
     * @param filename filename.
     */
    public FileRead(String filename) {
        try {
            Path path = Paths.get(filename);
            reader = Files.newBufferedReader(path);
        } catch (NoSuchFileException e) {
            System.out.println("No such file");
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Read data.
     *
     * @return line with text read.
     */
    public String readData() {
        try {
            line = reader.readLine();
            if (line == null) {
                return null;
            } else {
                return line;
            }
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Close FileReader.
     */
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
