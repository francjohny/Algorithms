package RunLengthEncoding;

import java.util.Scanner;

/*
 * Run-length encoding (RLE) is a very simple form of data compression in which runs of data
 * (that is, sequences in which the same data value occurs in many consecutive data elements)
 * are stored as a single data value and count, rather than as the original run.
 *
 * Bob wrote some code to solve the following problem:
 * Given an input string, write a function that returns the Run Length Encoded string for the input string.
 * For example, if the input string is AABBBCCCC, then the function should return A2B3C4.
 *
 * Input:
 * AABBBCCCC
 *
 * Output:
 * A2B3C4
 */
public class Naive {

    private static String encode(String source) {
        StringBuilder dest = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i + 1 < source.length() && source.charAt(i + 1) == source.charAt(i)) {
                runLength++;
                i++;
            }

            dest.append(source.charAt(i));
            dest.append(runLength);
        }
        return dest.toString();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(encode(s));

    }
}
