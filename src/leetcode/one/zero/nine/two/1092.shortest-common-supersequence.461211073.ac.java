package leetcode.one.zero.nine.two;

import java.util.Arrays;

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        String[][] dp = new String[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        return buildSequence(str1, str2, dp[n][m]);
    }
    
    private String buildSequence(String str1, String str2, String dp) {
        int i = 0, j = 0;
        char[] commonChars = dp.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char ch : commonChars) {
            while (ch != str1.charAt(i)) {
                result.append(str1.charAt(i++));
            }
            while (ch != str2.charAt(j)) {
                result.append(str2.charAt(j++));
            }
            result.append(ch);
            i++;
            j++;
        }
        result.append(str1.substring(i)).append(str2.substring(j));
        return result.toString();
    }
}
