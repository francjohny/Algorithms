package MaxBits;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int k = calculateSign(a - b);
        int q = flipBit(k);

        System.out.println(a * k + b * q);
    }

    /*
    * Returns 1 if a > 0 (positive)
    * Returns 0 if a < 0 (negative)
    */
    private static int calculateSign(int a) {
        return flipBit((a >> 31) & 0x1);
    }

    private static int flipBit(int a) {
        return a ^ 0x1;
    }
}
