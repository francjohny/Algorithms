package StringReservePreserveSpace;

import java.util.Arrays;
import java.util.Stack;

public class StringReversePreserveSpace {
    public static void main(String[] args) {
        String str = "1123 4234       5435";
        String[] split = str.split("[ ]+");
        Stack<String> strings = new Stack<>();
        strings.addAll(Arrays.asList(split));
        int i = 1;
        while (!strings.empty()) {
            String pop = strings.pop();
            System.out.print(pop);
            if (i < split.length)
                printSpace(str, split[i++]);
        }
    }

    private static void printSpace(String str, String split) {
        int i = str.indexOf(split), j;
        for (j = i; j - 1 > 0 && str.charAt(j - 1) == ' '; j--)
            System.out.print(" ");
    }
}
