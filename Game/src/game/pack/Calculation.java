package game.pack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class Calculation {
    /**
     * MAGIC NUMBER.
     */
    public static final int FOUR = 4;

    /**
     * MAGIC NUMBER.
     */
    public static final int TEN = 10;

    /**
     * MAGIC NUMBER.
     */
    public static final int THIRTY = 30;

    /**
     * MAGIC NUMBER.
     */
    public static final int THREE = 3;

    /**
     * ArrayList Sequence.
     */
    private ArrayList<String> sequence;

    /**
     * Start amount of coins.
     */
    private int startAmount;

    /**
     * Current amount of coins.
     */
    private int currentAmount = 0;

    /**
     * Play amount.
     */
    private int playAmount = 1;

    /**
     * Win amount.
     */
    private int winAmount = 0;

    /**
     * Played once.
     */
    private boolean playedOnce = false;


    /**
     * Constructor.
     *
     * @param startAmount start amount.
     */
    public Calculation(int startAmount) {
        this.startAmount = startAmount;
        currentAmount = startAmount;
    }

    /**
     * Is Played Once.
     *
     * @return boolean.
     */
    public boolean isPlayedOnce() {
        return playedOnce;
    }


    /**
     * Get win amount.
     *
     * @return winamount.
     */
    public int getWinAmount() {
        return winAmount;
    }

    /**
     * Play possible.
     *
     * @return boolean.
     */
    public boolean playPossible() {
        return currentAmount >= playAmount;
    }


    /**
     * Parse to get 'Joker', 'Apple' etc from file path.
     *
     * @param filepath1 filepath1.
     * @param filepath2 filepath2.
     * @param filepath3 filepath3.
     */
    public void parse(String filepath1, String filepath2, String filepath3) {
        sequence = new ArrayList<>();

        String[] splitPath1 = filepath1.split("\\\\")[THREE].split("\\.");
        String element1 = splitPath1[0];
        System.out.println("1" + element1);
        sequence.add(element1);

        String[] splitPath2 = filepath2.split("\\\\")[THREE].split("\\.");
        String element2 = splitPath2[0];
        System.out.println("2" + element2);
        sequence.add(element2);

        String[] splitPath3 = filepath3.split("\\\\")[THREE].split("\\.");
        String element3 = splitPath3[0];
        System.out.println("3" + element3);
        sequence.add(element3);
    }


    /**
     * Evaluate.
     *
     * @return evaluate verdict in text form.
     */
    public String evaluate() {
        playedOnce = true;

        if (currentAmount <= 0) {
            return "Game over!";
        }
        System.out.println("You had " + currentAmount);
        currentAmount -= playAmount;
        System.out.println("- " + playAmount + " = " + currentAmount);

        if (Collections.frequency(sequence, "Joker") == THREE) {
            winAmount = THIRTY * playAmount;
            currentAmount += winAmount;
            System.out.println("Three Jokers +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "WIN!!! Three Jokers!!!";

        } else if (Collections.frequency(sequence, "Banana") == THREE || Collections.frequency(sequence, "Lemon") == THREE || Collections.frequency(sequence, "Orange") == THREE || Collections.frequency(sequence, "Apple") == THREE || Collections.frequency(sequence, "Melon") == THREE || Collections.frequency(sequence, "Grape") == THREE || Collections.frequency(sequence, "Cherry") == THREE) {
            winAmount = TEN * playAmount;
            currentAmount += winAmount;
            System.out.println("Three Similar Fruits +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "WIN!!! Three Fruits!!!";

        } else if (Collections.frequency(sequence, "Joker") == 2) {
            winAmount = FOUR * playAmount;
            currentAmount += winAmount;
            System.out.println("Two Jokers +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "WIN!! Two Jokers!!";

        } else if (Collections.frequency(sequence, "Joker") == 1) {
            winAmount = playAmount;
            currentAmount += winAmount;
            System.out.println("Joker +" + winAmount);
            System.out.println("Final = " + currentAmount + " \n");
            return "WIN! One Joker!";
        } else {
            if (currentAmount == 0) {
                winAmount = 0;
                return "No coins left!";
            } else {
                winAmount = 0;
                System.out.println("LOST 0");
                System.out.println("Final = " + currentAmount + " \n");
                String[] anwsers = {"This time no luck!", "Try again!", "You'll win next time!", "Don't give up!", "You were so close!"};
                String randomString = anwsers[(int) (Math.random() * anwsers.length)];
                return randomString;
            }
        }
    }

    /**
     * Get play amount.
     *
     * @return boolean.
     */
    public int getPlayAmount() {
        return playAmount;
    }

    /**
     * Set play amount.
     *
     * @param playAmount set play amount.
     */
    public void setPlayAmount(int playAmount) {

        this.playAmount = playAmount;
    }

    /**
     * Get current amount.
     *
     * @return String.
     */
    public String getCurrentAmount() {
        return String.valueOf(currentAmount);
    }
}
