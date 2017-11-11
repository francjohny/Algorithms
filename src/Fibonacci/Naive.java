package Fibonacci;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int value = fibonacci(n - 1);
        System.out.println(value);
    }

    private static int fibonacci(int n) { // O(2^n)
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
