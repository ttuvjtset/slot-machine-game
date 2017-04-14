package game.pack;


public class HighScore {
    private int highScore = 0;
    LoadSaveScore lss;


    public HighScore (String filename){
        lss = new LoadSaveScore(filename);
        lss.checkAndLoadSettings();
        highScore = lss.getScoreRead();
    }


    public String save(String score) {
        if (Integer.valueOf(score) > highScore) {
            highScore = Integer.valueOf(score);
            lss.saveScore(highScore);
            return "TOP Score of " + highScore + " saved!";
        } else {
            return "Not greater than previously achieved " + highScore + "!";
        }
    }

    public int getHighScore() {
        return highScore;
    }
}
