package game.pack;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * CalculationTest.
 */
public class CalculationTest {
    /**
     * Is played once.
     *
     * @throws Exception Exception.
     */
    @Test
    public void isPlayedOnce() throws Exception {
        Calculation calculation = new Calculation(20);
        assertEquals(false, calculation.isPlayedOnce());
        calculation.parse("Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Joker.png");
        calculation.evaluate();
        assertEquals(true, calculation.isPlayedOnce());
    }

    /**
     * Get win amount one Joker.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getWinAmountOneJoker() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.parse("Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Joker.png");
        calculation.evaluate();
        assertEquals(1, calculation.getWinAmount());
    }

    /**
     * Get win amount two Jokers.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getWinAmountTwoJokers() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.parse("Game\\src\\images\\Joker.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Joker.png");
        calculation.evaluate();
        assertEquals(4, calculation.getWinAmount());
    }

    /**
     * Get win amount three Jokers.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getWinAmountThreeJokers() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.parse("Game\\src\\images\\Joker.png", "Game\\src\\images\\Joker.png", "Game\\src\\images\\Joker.png");
        calculation.evaluate();
        assertEquals(30, calculation.getWinAmount());
    }

    /**
     * Get win amount three different fruits.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getWinAmountThreeDifferentFruits() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.parse("Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png");
        calculation.evaluate();
        assertEquals(10, calculation.getWinAmount());
    }

    /**
     * Get win amount three same fruits.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getWinAmountThreeSameFruits() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.parse("Game\\src\\images\\Orange.png", "Game\\src\\images\\Apple.png", "Game\\src\\images\\Grape.png");
        calculation.evaluate();
        assertEquals(0, calculation.getWinAmount());
    }

    /**
     * Play possible.
     *
     * @throws Exception Exception.
     */
    @Test
    public void playPossible() throws Exception {
        Calculation calculation = new Calculation(20);
        assertEquals(true, calculation.playPossible());
    }

    /**
     * Play not possible.
     *
     * @throws Exception Exception.
     */
    @Test
    public void playNotPossible() throws Exception {
        Calculation calculation = new Calculation(0);
        assertEquals(false, calculation.playPossible());
    }

    /**
     * Play nothing lost.
     *
     * @throws Exception Exception.
     */
    @Test
    public void playNothingLost() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.parse("Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Joker.png");
        assertEquals("WIN! One Joker!", calculation.evaluate());

        calculation.parse("Game\\src\\images\\Grape.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Joker.png");
        assertEquals("WIN! One Joker!", calculation.evaluate());

        calculation.parse("Game\\src\\images\\Apple.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Joker.png");
        assertEquals("WIN! One Joker!", calculation.evaluate());

        assertEquals("20", calculation.getCurrentAmount());
    }

    /**
     * Get play amount.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getPlayAmount() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.setPlayAmount(5);
        assertEquals(5, calculation.getPlayAmount());
    }

    /**
     * Set play amount.
     *
     * @throws Exception Exception.
     */
    @Test
    public void setPlayAmount() throws Exception {
        Calculation calculation = new Calculation(20);
        calculation.setPlayAmount(5);
        assertEquals(5, calculation.getPlayAmount());
        calculation.parse("Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png", "Game\\src\\images\\Orange.png");
        calculation.evaluate();
        assertEquals("65", calculation.getCurrentAmount());

    }

    /**
     * Get current amount.
     *
     * @throws Exception Exception.
     */
    @Test
    public void getCurrentAmount() throws Exception {
        Calculation calculation = new Calculation(20);
        assertEquals("20", calculation.getCurrentAmount());
    }
}
