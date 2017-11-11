package StringPermutation;

import java.util.Scanner;

public class Recursion {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int totalPermutations = permutation("", str);
        System.out.println("\nTotal # of permutations: " + totalPermutations);
    }

    private static int permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            count++;
            System.out.print(prefix + " ");
        }
        else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
        return count;
    }
}
