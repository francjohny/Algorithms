package CodeforcesRaif.B;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            String chars = in.next();
            boolean hasOnlyC = true, hasOnlyA = true;
            for (int i = 0; i < n; i++) {
                char character = chars.charAt(i);
                if (character == '>') {
                    hasOnlyA = false;
                } else if (character == '<') {
                    hasOnlyC = false;
                }
            }
            if (hasOnlyA || hasOnlyC) {
                System.out.println(n);
            } else {
                int off = 0;
                for (int i = 0; i < n; i++) {
                    char character = chars.charAt(i);
                    char nextCharacter = chars.charAt((i + 1) % n);
                    if (character == '-' || nextCharacter == '-') {
                        off++;
                    }
                }
                System.out.println(off);
            }
        }
    }
}
