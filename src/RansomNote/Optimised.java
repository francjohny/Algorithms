package RansomNote;

import CustomDataStructures.HashMapList;

import java.util.Scanner;

public class Optimised {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        HashMapList<Integer, String> magazine = new HashMapList<>(m);
        while(m-- > 0) {
            String str = in.next();
            magazine.put(str.hashCode(), str);
        }
        System.out.println(check(in, n, magazine));
    }

    private static String check(Scanner in, int n, HashMapList<Integer, String> magazine) {
        final String YES = "Yes";
        final String NO = "No";
        while (n-- > 0) {
            String str = in.next();
            int result = magazine.remove(str.hashCode(), str);
            if (result == 0)
                return NO;
        }
        return YES;
    }
}
