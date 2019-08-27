package Substring;

import IO.FastIO;

public class Naive {

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        String str = fastIO.next();
        String pattern = fastIO.next();
        boolean isSubstring = checkSubstring(str, pattern);
        if (isSubstring)
            System.out.println("Substring");
        else
            System.out.println("Not a substring");
    }

    private static boolean checkSubstring(String str, String pattern) { // O(n^2)
        int textLen = str.length();
        int patternLen = pattern.length();
        int slidingWidth = textLen - patternLen + 1;
        int i, j;
        for (i = 0; i < slidingWidth; i++) { // O(n-m+1)
            for (j = 0; j < patternLen && pattern.charAt(j) == str.charAt(j + i); j++) ; // O(m)
            if (j >= patternLen)
                return true;
        }
        return false;
    }
}
