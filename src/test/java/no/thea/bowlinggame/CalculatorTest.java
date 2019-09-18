package no.thea.bowlinggame;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

;

/**
 *
 * @author thea
 */
public class CalculatorTest {

    @Test
    public void nullTest() {
        assertEquals(0, new Calculator(null).getScore());
    }

    @Test
    public void gutterBalls() {
        char[] array = new char[20];
        Arrays.fill(array, '-');
        assertEquals(0, new Calculator(array).getScore());
    }

    @Test
    public void strikes() {
        char[] array = new char[12];
        Arrays.fill(array, 'X');
        assertEquals(300, new Calculator(array).getScore());
    }

    @Test
    public void allOnes() {
        char[] array = new char[20];
        for (int i = 0; i < 20; i += 1) {
            array[i] = 1;
        }
        assertEquals(20, new Calculator(array).getScore());
    }

    @Test
    public void nineAndMiss() {
        char[] array = new char[20];
        for (int i = 0; i < 20; i += 2) {
            array[i] = 9;
            array[i + 1] = '-';
        }
        assertEquals(90, new Calculator(array).getScore());
    }

    @Test
    public void fiveAndSpare() {
        char[] array = new char[21];
        for (int i = 0; i < 20; i += 2) {
            array[i] = 5;
            array[i + 1] = '/';
        }
        array[array.length - 1] = 5;
        assertEquals(150, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameStrikeTest1() {
        char[] array = {'X', 1, 2};
        assertEquals(13, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameStrikeTest2() {
        char[] array = {'X', 'X', 2};
        assertEquals(22, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameStrikeTest3() {
        //Not possible
        char[] array = {'X', 1, 'X'};
        assertEquals(21, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameStrikeSpareTest1() {
        char[] array = {'X', 1, '/'};
        assertEquals(20, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameFullStrikeTest() {
        char[] array = {9, '/', '-', '/', 'X', 'X', 6, 2, 7, '/', 8, '/', 'X', 9, '-', 'X', 'X', 2};
        assertEquals(170, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameSpareTest1() {
        char[] array = {2, '/', 5};
        assertEquals(15, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameSpareTest2() {
        char[] array = {2, '/', 'X'};
        assertEquals(20, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameSpareTest3() {
        char[] array = {2, '/', '-'};
        assertEquals(10, new Calculator(array).getScore());
    }

    @Test
    public void lastFrameFullSpareTest3() {
        char[] array = {9, '/', '-', '/', 'X', 'X', 6, 2, 7, '/', 8, '/', 'X', 9, '-', 2, '/', '-'};

        assertEquals(158, new Calculator(array).getScore());
    }

    @Test
    public void spareFirst() {
        char[] array = {5, '/', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(29, new Calculator(array).getScore());
    }

    @Test
    public void strikeFirst() {
        char[] array = {'X', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(30, new Calculator(array).getScore());
    }

    @Test
    public void random1() {
        char[] array = {1, 4, 4, 5, 6, '/', 5, '/', 'X', '-', 1, 7, '/', 6, '/', 'X', 2, '/', 6};
        assertEquals(133, new Calculator(array).getScore());
    }

    @Test
    public void random2() {
        char[] array = {9, '/', '-', '/', 'X', 'X', 6, 2, 7, '/', 8, '/', 'X', 9, '-', 'X', 'X', 8};
        assertEquals(176, new Calculator(array).getScore());
    }

    public void noStrikeSpareGame() {
        char[] array = {0, 1, 3, 2, 0, 1, 3, 2, 0, 1, 3, 2, 0, 1, 3, 2, 0, 1, 3, 2};
        assertEquals(30, new Calculator(array).getScore());
    }

    @Test
    public void extraLongForFun() {
        char[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 'X', 6, 1};
        assertEquals(39, new Calculator(array).getScore());
    }
}
