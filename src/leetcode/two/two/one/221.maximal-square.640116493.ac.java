package leetcode.two.two.one;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]);
                    max = Math.max(dp[i + 1][j + 1], max);
                }
            }
        }
        return max * max;
    }
}
