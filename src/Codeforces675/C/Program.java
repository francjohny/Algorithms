package Codeforces675.C;

import java.util.Scanner;

public class Program {
    private static final long modulo = (long) (1e9 + 7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = str.length();
        long sum = 0;
        long tenPow = 1;
        long multiple = 1;
        long tens = 0;
        for (int i = n; i > 0; i--) {
            int digit = str.charAt(i - 1) - '0';
            sum = add(sum, mul(mul(nc2(i - 1), digit), tenPow));
            sum = add(sum, mul(digit, tens));
            tens = add(mul(multiple, tenPow), tens);
            multiple = add(multiple, 1);
            tenPow = mul(tenPow, 10);
        }

        System.out.println(sum);
    }

    private static long add(long a, long b) {
        return (((a + b) % modulo) + modulo) % modulo;
    }

    private static long mul(long a, long b) {
        return (((a * b) % modulo) + modulo) % modulo;
    }

    private static long nc2(long n) {
        return add(n * (n + 1) / 2, 0);
    }
}
