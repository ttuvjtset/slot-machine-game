package game.pack;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * File Writer tests.
 */
public class FileWriteTest {
    /**
     * Write zero to the file and read it.
     *
     * @throws Exception Exception
     */
    @Test
    public void writeDataZero() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test_write.txt");
        fw.writeData("0");
        fw.close();

        FileRead fr = new FileRead("src\\test\\test_write.txt");

        assertEquals("0", fr.readData());

    }

    /**
     * Read only the first line, ignore other.
     *
     * @throws Exception Exception.
     */
    @Test
    public void writeDataLongerTextWithNewLines() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test_write.txt");
        fw.writeData("test\ntext\njava");
        fw.close();

        FileRead fr = new FileRead("src\\test\\test_write.txt");

        assertEquals("test", fr.readData());

    }

    /**
     * Read only the first line, ignore other test 2
     *
     * @throws Exception Exception.
     */
    @Test
    public void writeDataNewLine() throws Exception {
        FileWrite fw = new FileWrite("src\\test\\test_write.txt");
        fw.writeData("\n");
        fw.close();

        FileRead fr = new FileRead("src\\test\\test_write.txt");

        assertEquals("", fr.readData());

    }

}