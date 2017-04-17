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

        String settingsFilename = "Game/src/settings/settings.txt";
        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);
        lrs.getCoinsRead();
        lrs.getDifficultyRead();

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