package StringPermutation;

import java.util.Scanner;

public class RecursionNoOrder {
    private static void permute(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        permute(a, n);
    }

    private static void permute(char[] a, int n) {
        if (n == 1) {
            System.out.println(new String(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            permute(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        permute(elements);
    }
}
