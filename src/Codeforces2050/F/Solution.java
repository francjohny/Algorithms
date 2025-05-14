package Codeforces2050.F;

import java.util.Scanner;

public class Solution {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // compute greatest common divisor of an array of elements
    public static int gcd(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int result = Math.abs(arr[l + 1] - arr[l]);
        for (int i = l + 2; i <= r; i++) {
            result = gcd(result, Math.abs(arr[i] - arr[i - 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int q = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            while (q-- > 0) {
                int l = in.nextInt();
                int r = in.nextInt();
                System.out.print(gcd(arr, l - 1, r - 1) + " ");
            }
            System.out.println();
        }
    }
}
