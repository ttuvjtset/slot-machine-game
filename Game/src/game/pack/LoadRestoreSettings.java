package game.pack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoadRestoreSettings {
    public String filename;

    public boolean dataCorrupted = false;

    public int coinsRead = 0;

    public String difficultyRead;



    public boolean dataRestored = false;


    public LoadRestoreSettings(String filename) {
        this.filename = filename;
        checkAndLoadSettings();
    }

    public String getDifficultyRead() {
        return difficultyRead;
    }

    public boolean isDataRestored() {
        return dataRestored;
    }

    public int getCoinsRead() {
        return coinsRead;
    }

    public void checkAndLoadSettings() {
        openAndCheckIfCorruptedOrLoadData();

        if (dataCorrupted) {
            rewriteWithDefaults();
            dataRestored = true;
            openAndCheckIfCorruptedOrLoadData();
            dataCorrupted = false;
        }
    }

    public void rewriteWithDefaults() {
        FileWrite fw = new FileWrite(filename);
        fw.writeData("5;normal");
        fw.close();
    }

    private void openAndCheckIfCorruptedOrLoadData() {
        FileRead fr = new FileRead(filename);
        String line = fr.readData();
        if (!dataVerification(line)) dataCorrupted = true;
        fr.close();
    }

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
                    if (coinsAmount > 0 && coinsAmount <= 100 && (difficulty.equals("normal") || difficulty.equals("hard"))) {
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
