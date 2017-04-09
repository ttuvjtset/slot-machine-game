package game.pack;

import java.util.Random;


public class Game {

    public String generate() {
        String[] reel = {"Joker", "Banana", "Lemon", "Orange", "Apple", "Melon"};
        return getRandom(reel);

    }

    public static String getRandom(String[] array) {
        int randomItem = new Random().nextInt(array.length);
        return array[randomItem];
    }
}
