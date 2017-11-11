package Fibonacci;

import java.util.Scanner;

public class Iterative {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibonacci(n - 1));
        System.out.println(fibonacci1(n - 1));
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }

    private static int fibonacci1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1, c;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }
}
