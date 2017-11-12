package Fibonacci;

import java.util.HashMap;
import java.util.Scanner;

public class TopDownDPSolution {
    private static HashMap<Long, Long> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long value = fibonacci(n - 1);
        System.out.println(value);
    }

    private static long fibonacci(long n) { // O(n)
        if (n == 0 || n == 1) {
            return n;
        }
        hashMap.computeIfAbsent(n, n1 -> hashMap.put(n, fibonacci(n1 - 1) + fibonacci(n1 - 2)));
        return hashMap.get(n);
    }
}
