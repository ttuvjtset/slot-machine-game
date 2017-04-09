import java.util.Random;

/**
 * Created by root on 09.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        String[] reel = {"Joker", "Banana", "Lemon", "Orange", "Apple", "Melon"};
        System.out.println(getRandom(reel));

    }

    public static String getRandom(String[] array) {
        int randomItem = new Random().nextInt(array.length);
        return array[randomItem];
    }
}
