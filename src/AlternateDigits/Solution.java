package AlternateDigits;

import java.util.Scanner;

public class Solution {
    private static int n = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(removeAlternateDigits(num));
    }

    private static int removeAlternateDigits(int num) {
        int len = (int) Math.log10(num) + 1;
        if (len == 1)
            return n;
        final int pow = (int) Math.pow(10, len - 1);
        if (len % 2 == 0) {
            int digit = num / pow;
            n = digit + n * 10;
        }
        int exFirstDigit = num % pow;
        return removeAlternateDigits(exFirstDigit);
    }
}
