package leetcode.one.six.two.five;

import java.util.HashSet;
import java.util.Set;

class Solution {
    String min;
    public String findLexSmallestString(String s, int a, int b) {
        min = s;
        dfs(s, a, b, new HashSet<>());
        return min;
    }
    
    private void dfs(String s, int a, int b, Set<String> seen) {
        int n = s.length();
        if (!seen.add(s)) {
            return;
        }
        min = min.compareTo(s) < 0 ? min : s;
        StringBuilder sb = new StringBuilder(s); 
        for(int i = 1; i < n; i += 2) {
            int newDigit = ((sb.charAt(i) - '0') + a) % 10;
            sb.setCharAt(i, Character.forDigit(newDigit, 10));
        }
        dfs(sb.toString(), a, b, seen);
        dfs(new StringBuilder(sb.substring(b)).append(sb.substring(0, b)).toString(), a, b, seen);
    }
}

