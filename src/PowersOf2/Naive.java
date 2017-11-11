package PowersOf2;

import java.util.Scanner;

/* Some helpful utility snippets:
 * 1) test if kth bit is set: num & (1 << k) != 0
 * 2) set kth bit: num |= (1 << k)
 * 3) turn off the kth bit: num &= ~(1 << k)
 * 4) toggle the kth bit: num ^= (1 << k)
 * 5) check if power of 2: num & num - 1 == 0
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print((1 << i) + " "); // computes 2^i
        }
        System.out.println();
    }
}
