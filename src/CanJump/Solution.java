package CanJump;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j <= i + nums[i]) {
                    dp[i][j] = 1;
                }
            }
        }
        return canJump(nums, dp, 0);
    }

    private boolean canJump(int[] nums, int[][] dp, int start) {
        if (start == nums.length - 1) {
            return true;
        }
        for (int col = dp[start].length - 1; col >= 0; col--) {
            if (dp[start][col] == 1) {
                if (canJump(nums, dp, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}