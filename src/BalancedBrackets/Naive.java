package BalancedBrackets;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String str = in.next();
            String result = checkBalancedBrackets(str);
            System.out.println(result);
        }
    }

    private static String checkBalancedBrackets(String str) {
        final String YES = "YES";
        final String NO = "NO";
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{', '}');
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        if (str.length() % 2 != 0)
            return NO;
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                try {
                    Character top = stack.peek();
                    if (str.charAt(i) == hashMap.get(top)) {
                        stack.pop();
                    } else
                        return NO;
                } catch (EmptyStackException e) {
                    return NO;
                }
            }
        }
        if (stack.isEmpty())
            return YES;
        else
            return NO;
    }
}
