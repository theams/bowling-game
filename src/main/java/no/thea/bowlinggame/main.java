package no.thea.bowlinggame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author thea
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter bowling line: ");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            inputString = inputString.replace(",", "");
            inputString = inputString.replace(" ", "");
            char[] stringToCharArray = inputString.toCharArray();
            System.out.println("Your total score is: " + new Calculator(fix(stringToCharArray)).getScore());
        }

    }

    private static char[] fix(char[] in) {
        for (int i = 0; i < in.length; i++) {
            char c = in[i];
            if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                in[i] = (char) Integer.parseInt(String.valueOf(c));

            }
        }
        return in;
    }

}
