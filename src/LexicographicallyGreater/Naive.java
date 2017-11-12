package LexicographicallyGreater;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Naive {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < n; i++)
            s[i] = in.next();
        for (int i = 0; i < n; i++) {
            TreeSet<String> strings = new TreeSet<>();
            if (s[i].chars().distinct().count() == 1) {
                System.out.println("no answer");
                continue;
            }
            permutation(s[i]);
            strings.addAll(Arrays.asList(stringBuilder.toString().split("\\n")));
            System.out.println(strings.higher(s[i]));
            stringBuilder = new StringBuilder();
        }
    }

    private static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) stringBuilder.append(prefix).append("\n");
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
