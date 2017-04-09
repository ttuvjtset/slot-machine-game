package game.pack;

import java.util.ArrayList;
import java.util.Collections;


public class Calculation {
    public ArrayList<String> sequence;

    int startAmount = 5;

    int currentAmount = 0;

    public Calculation() {
        currentAmount = startAmount;
    }

    public void parse(String filepath1, String filepath2, String filepath3) {
        sequence = new ArrayList<>();

        String[] splitPath1 = filepath1.split("\\\\")[3].split("\\.");
        String element1 = splitPath1[0];
        System.out.println(element1);
        sequence.add(element1);

        String[] splitPath2 = filepath2.split("\\\\")[3].split("\\.");
        String element2 = splitPath2[0];
        System.out.println(element2);
        sequence.add(element2);

        String[] splitPath3 = filepath3.split("\\\\")[3].split("\\.");
        String element3 = splitPath3[0];
        System.out.println(element3);
        sequence.add(element3);
    }

    public String evaluate() {
        if (currentAmount <= 0) {
            return "Game over!";
        }
        System.out.println("bilo " + currentAmount);
        currentAmount -= 1;
        System.out.println("minus monetka" + currentAmount);

        if (Collections.frequency(sequence, "Joker") == 3) {
            System.out.println("Joker x3 +30");
            currentAmount += 30;
            System.out.println("final" + currentAmount + " \n");
            return "Joker x3";

        } else if (Collections.frequency(sequence, "Banana") == 3 || Collections.frequency(sequence, "Lemon") == 3 || Collections.frequency(sequence, "Orange") == 3 || Collections.frequency(sequence, "Apple") == 3 || Collections.frequency(sequence, "Melon") == 3) {
            System.out.println("Ne Joker x3 +10");
            currentAmount += 10;
            System.out.println("final" + currentAmount + " \n");
            return "Ne Joker x3";
        } else if (Collections.frequency(sequence, "Joker") == 2) {
            System.out.println("Joker x2 +4");
            currentAmount += 4;
            System.out.println("final" + currentAmount + " \n");
            return "Joker x2";
        } else if (Collections.frequency(sequence, "Joker") == 1) {
            System.out.println("Joker x1 +1");
            currentAmount += 1;
            System.out.println("final" + currentAmount + " \n");
            return "Joker x1";
        } else {
            if (currentAmount == 0) {
                return "Game over!";
            } else {
                System.out.println("LOST 0");
                System.out.println("final" + currentAmount + " \n");
                return "Lost!";
            }
        }

    }

    public String getCurrentAmount() {
        return String.valueOf(currentAmount);
    }
}
