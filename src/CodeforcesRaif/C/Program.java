package CodeforcesRaif.C;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            String str = scanner.next();
            System.out.println(getLengthOfSmallestSubstring(str, Integer.MAX_VALUE));
        }
    }

    private static int getLengthOfSmallestSubstring(String str, int min) {
        for (int i = 0; i + 2 <= str.length(); i++) {
            if (str.startsWith("AB", i) || str.startsWith("BB", i)) {
                String str1 = str.substring(0, i) + str.substring(i + 2);
                min = getLengthOfSmallestSubstring(str1, min);
                return Math.min(min, str.length());
            }
        }
        return Math.min(min, str.length());
    }
}
