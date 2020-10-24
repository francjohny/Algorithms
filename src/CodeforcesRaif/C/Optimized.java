package CodeforcesRaif.C;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Optimized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            String str = scanner.next();
            System.out.println(getLengthOfSmallestSubstring(str));
        }
    }

    private static int getLengthOfSmallestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }
        Deque<Character> stack = new ArrayDeque<>();
        stack.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != 'B' || stack.isEmpty()) {
                stack.add(str.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.size();
    }
}
