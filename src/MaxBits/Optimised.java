package MaxBits;

import java.util.Scanner;

public class Optimised {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int sign_a = calculateSign(a);
        int sign_b = calculateSign(b);
        int sign_diff = calculateSign(a - b);

        // If a and b have different signs, then k = sign(a)
        int use_sign_a = sign_a ^ sign_b;
        // If a and b have same signs, then k = sign(diff)
        int use_sign_diff = flipBit(use_sign_a);

        int k = use_sign_a * sign_a + use_sign_diff * sign_diff;
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
