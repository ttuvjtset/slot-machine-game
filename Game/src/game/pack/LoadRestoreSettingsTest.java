package game.pack;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * LoadRestoreSettingsTest.
 */
public class LoadRestoreSettingsTest {
    /**
     * Normal situation.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getDifficultyandCoinsRead() throws Exception {

        String settingsFilename = "src\\test\\test1.txt";
        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);

        assertEquals(22, lrs.getCoinsRead());
        assertEquals("normal", lrs.getDifficultyRead());
        assertEquals(false, lrs.isDataRestored());

    }

    /**
     * Corrupted data constellation 2.
     *
     * @throws Exception Exception.
     */
    @Test
    public void checkSettingsDataCorruption() throws Exception {
        String settingsFilename = "src\\test\\test2.txt";
        FileWrite fw = new FileWrite(settingsFilename);
        fw.writeData("xxx;xxx");
        fw.close();
        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);
        assertEquals(5, lrs.getCoinsRead());
        assertEquals("normal", lrs.getDifficultyRead());
        assertEquals(true, lrs.isDataRestored());
    }

    /**
     * Corrupted data constellation 2.
     *
     * @throws Exception Exception.
     */
    @Test
    public void checkSettingsDataCorruption2() throws Exception {
        String settingsFilename = "src\\test\\test2.txt";
        FileWrite fw = new FileWrite(settingsFilename);
        fw.writeData("-5sa5");
        fw.close();
        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);
        assertEquals(5, lrs.getCoinsRead());
        assertEquals("normal", lrs.getDifficultyRead());
        assertEquals(true, lrs.isDataRestored());
    }

    /**
     * Corrupted data constellation 3.
     *
     * @throws Exception
     */
    @Test
    public void checkSettingsDataCorruption3() throws Exception {
        String settingsFilename = "src\\test\\test2.txt";
        FileWrite fw = new FileWrite(settingsFilename);
        fw.writeData("\n\n99;hard");
        fw.close();
        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);
        assertEquals(5, lrs.getCoinsRead());
        assertEquals("normal", lrs.getDifficultyRead());
        assertEquals(true, lrs.isDataRestored());
    }


}