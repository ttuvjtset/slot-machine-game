package game.pack;

/**
 * HighScore class.
 */
public class HighScore {
    /**
     * HighScore.
     */
    private int highScore = 0;

    /**
     * LoadSaveScore object.
     */
    private LoadSaveScore lss;

    /**
     * High Score.
     *
     * @param filename filename.
     */
    public HighScore(String filename) {
        lss = new LoadSaveScore(filename);
        lss.checkAndLoadSettings();
        highScore = lss.getScoreRead();
    }

    /**
     * Save score.
     *
     * @param score score to save.
     * @return answer after saving if successfully.
     */
    public String save(String score) {
        if (Integer.valueOf(score) > highScore) {
            highScore = Integer.valueOf(score);
            lss.saveScore(highScore);
            return "TOP Score of " + highScore + " saved!";
        } else {
            return "Not greater than previously achieved " + highScore + "!";
        }
    }

    /**
     * Get high score.
     *
     * @return highScore.
     */
    public int getHighScore() {
        return highScore;
    }
}
