package game.pack;

import java.util.ArrayList;
import java.util.Collections;


public class Calculation {
    public ArrayList<String> sequence;

    int startAmount;
    int currentAmount = 0;
    int playAmount = 1;
    int winAmount = 0;

    public int getWinAmount() {
        return winAmount;
    }

    public boolean playPossible() {
        return currentAmount >= playAmount;
    }

//    public void setStartAmount(int startAmount) {
//        this.startAmount = startAmount;
//        currentAmount = startAmount;
//    }

    public Calculation(int startAmount) {
        this.startAmount = startAmount;
        currentAmount = startAmount;
    }

    public void parse(String filepath1, String filepath2, String filepath3) {
        sequence = new ArrayList<>();

        String[] splitPath1 = filepath1.split("\\\\")[3].split("\\.");
        String element1 = splitPath1[0];
        System.out.println("1" + element1);
        sequence.add(element1);

        String[] splitPath2 = filepath2.split("\\\\")[3].split("\\.");
        String element2 = splitPath2[0];
        System.out.println("2" + element2);
        sequence.add(element2);

        String[] splitPath3 = filepath3.split("\\\\")[3].split("\\.");
        String element3 = splitPath3[0];
        System.out.println("3" + element3);
        sequence.add(element3);
    }

    public String evaluate() {
        if (currentAmount <= 0) {
            return "Game over!";
        }
        System.out.println("You had " + currentAmount);
        currentAmount -= playAmount;
        System.out.println("- " + playAmount + " = " + currentAmount);

        if (Collections.frequency(sequence, "Joker") == 3) {
            winAmount = 30 * playAmount;
            currentAmount += winAmount;
            System.out.println("Three Jokers +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "Three Jokers!!!";

        } else if (Collections.frequency(sequence, "Banana") == 3 || Collections.frequency(sequence, "Lemon") == 3 || Collections.frequency(sequence, "Orange") == 3 || Collections.frequency(sequence, "Apple") == 3 || Collections.frequency(sequence, "Melon") == 3 || Collections.frequency(sequence, "Grape") == 3 || Collections.frequency(sequence, "Cherry") == 3) {
            winAmount = 10 * playAmount;
            currentAmount += winAmount;
            System.out.println("Three Similar Fruits +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "Three Similar Fruits!!!";

        } else if (Collections.frequency(sequence, "Joker") == 2) {
            winAmount = 4 * playAmount;
            currentAmount += winAmount;
            System.out.println("Two Jokers +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "Two Jokers!!";

        } else if (Collections.frequency(sequence, "Joker") == 1) {
            winAmount = playAmount;
            currentAmount += winAmount;
            System.out.println("Joker +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "One Joker!";
        } else {
            if (currentAmount == 0) {
                winAmount = 0;
                return "Game over!";
            } else {
                winAmount = 0;
                System.out.println("LOST 0");
                System.out.println("Final = " + currentAmount + " \n");
                return "";
            }
        }

    }

    public int getPlayAmount() {
        return playAmount;
    }

    public void setPlayAmount(int playAmount) {

        this.playAmount = playAmount;
    }

    public String getCurrentAmount() {
        return String.valueOf(currentAmount);
    }
}
