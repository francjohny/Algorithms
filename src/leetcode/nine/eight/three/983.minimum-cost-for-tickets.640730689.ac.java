package leetcode.nine.eight.three;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n = days.length;
        List<Integer> d = Arrays.stream(days).boxed().collect(Collectors.toList());
        int[] dp = new int[30];
        dp[0] = 0;
        for (int i = 1; i <= 365; i++) {
            if (d.contains(i)) {
                int dayCost = dp[(i - 1) % 30] + cost[0];
                int weekCost = dp[Math.max(0, (i - 7 ) % 30)] + cost[1];
                int monthCost = dp[Math.max(0, (i - 30) % 30)] + cost[2];
                dp[i % 30] = Math.min(Math.min(dayCost, weekCost), monthCost);
            } else {
                dp[i % 30] = dp[(i - 1) % 30];
            }
        }
        return dp[days[n - 1] % 30];
    }
}
