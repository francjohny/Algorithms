package leetcode.five.six.one;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i + 1 < nums.length; i+=2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }
}
