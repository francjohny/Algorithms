package leetcode.two.two.one.zero;

class Solution {
    public int countHillValley(int[] nums) {
       int n = nums.length, ans = 0, left = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if ((nums[i] < left && nums[i] < nums[i + 1]) || (nums[i] > left && nums[i] > nums[i + 1])) {
                ans++;
                left = nums[i];
            }
        }
        return ans;
    }
}
