package Factorial;

import java.util.Scanner;

public class TailRecursive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(factorial(n, 1));
    }

    private static long factorial(long n, long sum) {
        if (n == 1 || n == 0)
            return sum;
        return factorial(n - 1, n * sum);
    }
}
