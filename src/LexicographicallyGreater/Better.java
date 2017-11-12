package LexicographicallyGreater;

import java.util.Scanner;

public class Better {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        for (String string : strings) {
            String nextPermutation = findNextPermutation(string);
            if (nextPermutation == null)
                System.out.println("no answer");
            else
                System.out.println(nextPermutation);
        }
    }

    private static String findNextPermutation(String string) {
        if (string.length() == 1)
            return null;

        int n = string.length();
        int p = -1, q = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (string.charAt(i) < string.charAt(i + 1)) {
                p = i;
                break;
            }
        }
        if (p < 0)
            return null;

        for (int i = n - 1; i >= 0; i--) {
            if (string.charAt(i) > string.charAt(p)) {
                q = i;
                break;
            }
        }
        String swap = swap(string, p, q);
        return swap.substring(0, p + 1) + new StringBuilder(swap.substring(p + 1)).reverse().toString();
    }

    private static String swap(String string, int p, int q) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.setCharAt(p, string.charAt(q));
        stringBuilder.setCharAt(q, string.charAt(p));
        return stringBuilder.toString();
    }
}
