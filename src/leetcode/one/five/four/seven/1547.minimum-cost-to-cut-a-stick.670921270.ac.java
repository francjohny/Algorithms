package leetcode.one.five.four.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        List<Integer> c = new ArrayList<>();
        for(int cut: cuts) {
            c.add(cut);
        }
        c.add(0);
        c.add(n);
        int cutSize = c.size();
        dp = new int[cutSize][cutSize];
        Collections.sort(c);
        return getCost(c, 0, cutSize - 1);
    }
    
    private int getCost(List<Integer> cuts, int i, int j) {
        if (j <= i + 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], cuts.get(j) - cuts.get(i) + getCost(cuts, i, k) + getCost(cuts, k, j));
        }
        return dp[i][j];
    }
}
