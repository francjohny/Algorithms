package StringSimilarity;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/1400/problem/A
 */
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            String str = sc.next();
            System.out.println(similarString(str, n));
        }
    }

    private static String similarString(String str, int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            stringBuilder.append(str.charAt(2 * i));
        }
        return stringBuilder.toString();
    }
}
