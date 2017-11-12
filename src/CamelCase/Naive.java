package CamelCase;

import java.util.Scanner;

/*
 * Given s, print the number of words in s on a new line.
 *
 * Input: saveChangesInTheEditor
 * Output: 5
 */
public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int length = s.split("[A-Z]").length; // treat CAPS as delimiters
        System.out.println(length);
    }
}

