package JavaStack;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair
 * if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 * There are three types of matched pairs of brackets: [], {}, and ().
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 *
 * Input:
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 *
 * Output:
 * YES
 * NO
 * YES
 */
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
                    /*
                     * when the input is not well formed }{
                     * since the stack is initially empty, an exception is thrown when peeking the top of the stack.
                     */
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
