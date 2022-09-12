package leetcode.eight.seven.one;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1]; // dp[i] - max distance you can travel refuelling i times
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0 && dp[j] - stations[i][0] >= 0; j--) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                // System.out.println(i + " " + j + " " + Arrays.toString(dp));
            }
        }
        
        for (int i = 0; i <= n; i++) {
            if (dp[i] - target >= 0) {
                return i;
            }
        }
        return -1;
    }
}
