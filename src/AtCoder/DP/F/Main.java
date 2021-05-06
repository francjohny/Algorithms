package AtCoder.DP.F;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        // dp[i][j] - longest possible subsequence at index i of string s and index j of string t
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(buildSequence(dp, slen, tlen, t));
    }

    private static String buildSequence(int[][] dp, int slen, int tlen, String s) {
        StringBuilder sb = new StringBuilder();
        int i = slen, j = tlen;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                sb.insert(0, s.charAt(j - 1));
                i--;
                j--;
            }
        }
        return sb.toString();
    }
}
