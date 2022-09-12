package leetcode.one.zero.four.three;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--) {
            int max = 0, best = 0, len = 1, sum = 0;
            for(int j = i; j < Math.min(n, i + k); j++, len++) {
                max = Math.max(max, arr[j]);
                sum = max * len + dp[j + 1];
                best = Math.max(best, sum);
            }
            dp[i] = best;
        }
        return dp[0];
    }
}
