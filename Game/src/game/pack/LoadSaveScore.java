package game.pack;

/**
 * Created by root on 13.04.2017.
 */
public class LoadSaveScore {
    public String filename;

    public boolean dataRestored = false;

    public boolean dataCorrupted = false;

    int scoreRead;


    public boolean isDataRestored() {
        if (dataRestored) {
            dataRestored = false;
            return true;
        } else {
            return false;
        }
    }
    public LoadSaveScore(String filename) {
        this.filename = filename;
    }

    public void checkAndLoadSettings() {
        readScoreFile();

        if (dataCorrupted) {
            rewriteWithDefaults();
            dataRestored = true;
            readScoreFile();
            dataCorrupted = false;
        }
    }

    public void readScoreFile() {
        FileRead fr = new FileRead(filename);
        String line = fr.readData();
        if (!dataVerification(line)) dataCorrupted = true;
        fr.close();
    }

    public void rewriteWithDefaults() {
        FileWrite fw = new FileWrite(filename);
        fw.writeData("0");
        fw.close();
    }

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

    public int getScoreRead() {
        return scoreRead;
    }

    public void saveScore(int score) {
        FileWrite fw = new FileWrite(filename);
        fw.writeData(String.valueOf(score));
        fw.close();
    }
}
