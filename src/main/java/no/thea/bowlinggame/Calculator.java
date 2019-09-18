package no.thea.bowlinggame;

import java.util.Arrays;

/**
 *
 * @author thea
 */
public class Calculator {

    private int totalScore;

    public Calculator(char[] line) {
        this.totalScore = 0;
        if (line == null) {
            return;
        }
        calculate(translateArray(line));
    }

    private int[] translateArray(char[] line) {
        int[] rolls = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            switch (line[i]) {
                case '-':
                case '0':
                    rolls[i] = 0;
                    break;
                case '/':
                    rolls[i] = 10 - rolls[i - 1];
                    break;
                case 'X':
                case 'x':
                    rolls[i] = 10;
                    break;
                default:
                    rolls[i] = line[i];
            }
        }
        return rolls;
    }

    public int getScore() {
        return this.totalScore;
    }

    public void calculate(int[] line) {
        if (line == null || line.length == 0) {
            return;
        }
        if (isStrike(line)) {
            if (line.length == 1 || line.length == 2) {
                return;
            }
            addScoreFrom(line, 3);
            if (line.length == 3) {
                return;
            }
            calculate(pop(line, 1));
        } else if (isSpare(line)) {
            addScoreFrom(line, 3);
            line = pop(line, 2);
            if (line.length == 1) {
                return;
            }
            calculate(line);
        } else if (line.length < 2) {
            addScoreFrom(line, 1);

        } else {
            addScoreFrom(line, 2);
            calculate(pop(line, 2));
        }
    }

    private void addScoreFrom(int[] line, int noElements) {
        for (int i = 0; i < noElements; i++) {
            totalScore += line[i];
        }
    }

    private boolean isStrike(int[] line) {
        return line[0] == 10;
    }

    private boolean isSpare(int[] line) {
        return line.length > 2 && line[0] + line[1] == 10;
    }

    private int[] pop(int[] arr, int noElements) {
        if (arr.length < noElements) {
            return null;
        }
        return Arrays.copyOfRange(arr, noElements, arr.length);
    }

}
