package LexicographicNumbers;

import java.util.Scanner;

/*
 * Given an integer N, print numbers from 1 to N in lexicographical order
 * Input:
 * 25
 *
 * Output:
 * 1 10 11 12 13 14 15 16 17 18 19 2 20 21 22 23 24 25
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int digitCount = countDigits(number);
        int hundredDigit = (int) (number / Math.pow(10, digitCount - 1));
        for (int i = 1; i <= hundredDigit; i++) {
            for (int j = 0; j < digitCount; j++) {
                double tensPow = Math.pow(10, j);
                for (int k = 0; k < tensPow; k++) {
                    int result = (int) (i * tensPow + k);
                    if (result > number)
                        return;
                    System.out.print(result + " ");
                }
            }
        }
    }

    private static int countDigits(int number) {
        int count = 0;
        while(number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
