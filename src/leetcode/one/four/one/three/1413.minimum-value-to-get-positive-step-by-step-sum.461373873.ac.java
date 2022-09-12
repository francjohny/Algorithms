package leetcode.one.four.one.three;

class Solution {
    public int minStartValue(int[] nums) {
        int start = 1;
        int sum = start;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum < 1) {
                start++;
                sum = start;
                i = -1;
            }
        }
        return start;
    }
}
