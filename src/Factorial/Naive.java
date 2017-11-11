package Factorial;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(factorial(n));
    }

    private static long factorial(long n) {
        if (n == 1 || n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
