package game.pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRead {

    String line;

    private BufferedReader reader;

//    public int getCoinsRead() {
//        return coinsRead;
//    }
//
//    int coinsRead = 0;
//
//    public String getDifficultyRead() {
//        return difficultyRead;
//    }
//
//    String difficultyRead;

    public FileRead(String filename) {
        try {
            Path path = Paths.get(filename);
            reader = Files.newBufferedReader(path);
        } catch (NoSuchFileException e) {
            System.out.println("No such file");
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public String readData() {
        try {
            line = reader.readLine();
            if (line == null) {
                return null;
            } else {
                return line;
            }
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

//    public boolean dataVerification() {
//        if (line != null) {
//            final String regex = "(\\d+)(;)((?:[a-z][a-z]+))";
//
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(line);
//
//            if (matcher.find()) {
//                int coinsAmount = 0;
//                String difficulty = "";
//                String[] splitString = line.trim().split(";");
//                try{
//                    coinsAmount = Integer.parseInt(splitString[0]);
//                    difficulty = splitString[1];
//                    if (coinsAmount > 0 && coinsAmount <= 100 && (difficulty.equals("normal") || difficulty.equals("hard"))){
//                        System.out.println("verified ok");
//                        coinsRead = coinsAmount;
//                        difficultyRead = difficulty;
//                        return true;
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Not an integer!");
//                }
//
//            }
//            return false;
//        }
//        return false;
//    }


    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
