package SuperReducedString;

import java.util.Scanner;

public class Naive {

    private static String super_reduced_string(String s){
        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i + 1 < stringBuilder.length(); i++) {
            if (stringBuilder.length() == 2 && adjacentCharsMatch(stringBuilder, i))
                return "Empty String";
            if (adjacentCharsMatch(stringBuilder, i)) {
                stringBuilder.setCharAt(i, ' ');
                stringBuilder.setCharAt(i + 1, ' ');
                stringBuilder = new StringBuilder(stringBuilder.toString().replaceAll(" ", ""));
                i = -1;
            }
        }
        return stringBuilder.toString();
    }

    private static boolean adjacentCharsMatch(StringBuilder stringBuilder, int i) {
        return stringBuilder.charAt(i) == stringBuilder.charAt(i + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
