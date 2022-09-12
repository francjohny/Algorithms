package leetcode.five.one.eight;

class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for (int num : coins) {
            for (int sum = num; sum <= amount; sum++) {
                dp[sum] += dp[sum - num];
            }
        }
        return dp[amount];
    }
}
