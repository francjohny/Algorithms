package leetcode.two.two.one.eight;

import java.util.List;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        Integer[][] dp = new Integer[n + 1][k + 1];
        return maxValueOfCoins(dp, piles, k, 0);
    }
    
    private int maxValueOfCoins(Integer[][] dp, List<List<Integer>> piles, int k, int idx) {
        if (idx == piles.size() || k == 0) {
            return 0;
        }
        if (dp[idx][k] != null) {
            return dp[idx][k];
        }
        int ans = 0, sum = 0;
        ans = Math.max(ans, maxValueOfCoins(dp, piles, k, idx + 1));
        for (int j = 0; j < Math.min(k, piles.get(idx).size()); j++) {
            sum += piles.get(idx).get(j);
            ans = Math.max(ans, sum + maxValueOfCoins(dp, piles, k - (j + 1), idx + 1));
        }
        return dp[idx][k] = ans;
    }
}
