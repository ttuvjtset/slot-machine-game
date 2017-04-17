package game.test;

import game.pack.LoadRestoreSettings;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by root on 17.04.2017.
 */
public class LoadRestoreSettingsTest {
    @Test
    public void getDifficultyRead() throws Exception {
//        "Game/src/score/score.txt";
//        Game\src\images\Apple.png
        String settingsFilename = "Game\\src\\game\\test\\test1.txt";
        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);

        assertEquals(true, lrs.isDataRestored());
    }

    @Test
    public void isDataRestored() throws Exception {

    }

    @Test
    public void getCoinsRead() throws Exception {

    }

    @Test
    public void checkAndLoadSettings() throws Exception {

    }

    @Test
    public void rewriteWithDefaults() throws Exception {

    }

    @Test
    public void dataVerification() throws Exception {

    }

}