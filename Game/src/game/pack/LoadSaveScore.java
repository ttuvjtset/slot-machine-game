package game.pack;

/**
 * Load and Save Score Class.
 */
public class LoadSaveScore {
    /**
     * Filename.
     */
    private String filename;

    /**
     * Boolean status for data restore.
     */
    private boolean dataRestored = false;

    /**
     * Boolean status for data corruption.
     */
    private boolean dataCorrupted = false;

    /**
     * Score read.
     */
    private int scoreRead;


    /**
     * Constructor.
     *
     * @param filename filename.
     */
    public LoadSaveScore(String filename) {
        this.filename = filename;
    }


    /**
     * Check if data was restored.
     *
     * @return boolean.
     */
    public boolean isDataRestored() {
        if (dataRestored) {
            dataRestored = false;
            return true;
        } else {
            return false;
        }
    }


    /**
     * Check and load settings.
     */
    public void checkAndLoadSettings() {
        readScoreFile();

        if (dataCorrupted) {
            rewriteWithDefaults();
            dataRestored = true;
            readScoreFile();
            dataCorrupted = false;
        }
    }

    /**
     * Read the score file.
     */
    public void readScoreFile() {
        FileRead fr = new FileRead(filename);
        String line = fr.readData();
        if (!dataVerification(line)) dataCorrupted = true;
        fr.close();
    }

    /**
     * Rewrite file with default settings.
     */
    public void rewriteWithDefaults() {
        FileWrite fw = new FileWrite(filename);
        fw.writeData("0");
        fw.close();
    }

    /**
     * Data verification.
     *
     * @param line sting text.
     * @return return true if integer.
     */
    public boolean dataVerification(String line) {
        try {
            scoreRead = Integer.valueOf(line);
            if (scoreRead >= 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Not an integer!");
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Get score read.
     *
     * @return ScoreRead.
     */
    public int getScoreRead() {
        return scoreRead;
    }

    /**
     * Save the score.
     *
     * @param score score.
     */
    public void saveScore(int score) {
        FileWrite fw = new FileWrite(filename);
        fw.writeData(String.valueOf(score));
        fw.close();
    }
}
