package game.pack;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * HighScoreTest.
 */
public class HighScoreTest {
    /**
     * Normal behaviour when overwriting data.
     *
     * @throws Exception Exception.
     */
    @Test
    public void saveAccepted() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test3.txt");
        fw.writeData("0");
        fw.close();
        HighScore hs = new HighScore("src\\test\\test3.txt");
        hs.save("5");
        assertEquals(5, hs.getHighScore());

    }

    /**
     * Save not executed because 5 > 4
     *
     * @throws Exception Exception.
     */
    @Test
    public void saveIgnored() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test3.txt");
        fw.writeData("5");
        fw.close();
        HighScore hs = new HighScore("src\\test\\test3.txt");
        hs.save("4");
        assertEquals(5, hs.getHighScore());

    }

    /**
     * Loaded data from file.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getHighScoreFiveHundered() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test3.txt");
        fw.writeData("500");
        fw.close();
        HighScore hs = new HighScore("src\\test\\test3.txt");
        assertEquals(500, hs.getHighScore());
    }

    /**
     * Corrupted data -> overwrite with default value, which is null.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getHighScoreCorrupted() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test3.txt");
        fw.writeData("corruptedData");
        fw.close();
        HighScore hs = new HighScore("src\\test\\test3.txt");
        assertEquals(0, hs.getHighScore());
    }

}