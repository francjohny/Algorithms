package JavaStack;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            boolean result = checkBalancedBrackets(str);
            System.out.println(result);
        }
    }

    private static boolean checkBalancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{', '}');
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        if (str.length() % 2 != 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                try {
                    Character top = stack.peek();
                    if (str.charAt(i) == hashMap.get(top)) {
                        stack.pop();
                    } else
                        return false;
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
