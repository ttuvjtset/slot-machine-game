package game.pack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class LoadRestoreSettings {

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int HUNDRED = 100;

    /**
     * filename.
     */
    public String filename;

    /**
     * Data corruption status.
     */
    public boolean dataCorrupted = false;

    /**
     * Coins read.
     */
    public int coinsRead = 0;

    /**
     * Difficulty read.
     */
    public String difficultyRead;

    /**
     * Data restored.
     */
    public boolean dataRestored = false;

    /**
     * Constructor.
     *
     * @param filename string filename.
     */
    public LoadRestoreSettings(String filename) {
        this.filename = filename;
        checkAndLoadSettings();
    }

    /**
     * Get difficulty read.
     *
     * @return String difficultyRead.
     */
    public String getDifficultyRead() {
        return difficultyRead;
    }

    /**
     * Is data restored
     *
     * @return boolean.
     */
    public boolean isDataRestored() {
        return dataRestored;
    }

    /**
     * Get coins read.
     *
     * @return coins read.
     */
    public int getCoinsRead() {
        return coinsRead;
    }

    /**
     * Check and load settings.
     */
    public void checkAndLoadSettings() {
        openAndCheckIfCorruptedOrLoadData();

        if (dataCorrupted) {
            rewriteWithDefaults();
            dataRestored = true;
            openAndCheckIfCorruptedOrLoadData();
            dataCorrupted = false;
        }
    }

    /**
     * Rewrite file with defaults.
     */
    public void rewriteWithDefaults() {
        FileWrite fw = new FileWrite(filename);
        fw.writeData("5;normal");
        fw.close();
    }

    /**
     * Open and check if data is corrupted or load the data.
     */
    private void openAndCheckIfCorruptedOrLoadData() {
        FileRead fr = new FileRead(filename);
        String line = fr.readData();
        if (!dataVerification(line)) dataCorrupted = true;
        fr.close();
    }

    /**
     * Data verification.
     *
     * @param line String line.
     * @return true if {number from zero to hundred} ; {normal or hard}
     */
    public boolean dataVerification(String line) {
        if (line != null) {
            final String regex = "(\\d+)(;)((?:[a-z][a-z]+))";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                int coinsAmount = 0;
                String difficulty = "";
                String[] splitString = line.trim().split(";");
                try {
                    coinsAmount = Integer.parseInt(splitString[0]);
                    difficulty = splitString[1];
                    if (coinsAmount > 0 && coinsAmount <= HUNDRED && (difficulty.equals("normal") || difficulty.equals("hard"))) {
                        System.out.println("verified ok");
                        coinsRead = coinsAmount;
                        difficultyRead = difficulty;
                        return true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Not an integer!");
                }
            }
            return false;
        }
        return false;
    }

}
