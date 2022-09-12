package leetcode.two.eight.three;

class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    public void moveZeroes(int[] nums) {
        int lastNonZeroPos = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, lastNonZeroPos++, i);
            }
        }
    }
}
