package AtCoder.DP.D;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] weights = new int[w + 1];
        int[] values = new int[n + 1];
        long[][] dp = new long[n + 1][w + 1];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[0][j] = 0;
                    continue;
                }
                if (j - weights[i - 1] >= 0) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
