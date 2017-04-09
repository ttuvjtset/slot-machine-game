package game.pack;


public class HighScore {
    private int highScore = 0;

    public void save(String score) {
        if (Integer.valueOf(score) > highScore) {
            highScore = Integer.valueOf(score);
            System.out.println("rewritten!");
        }
    }

    public int getHighScore() {
        return highScore;
    }
}
