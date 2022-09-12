package leetcode.one.three.six.five;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];
        for (int i = 0; i < n; i++) {
            count[nums[i]] += 1;
        }
        for (int i = 1; i < 101; i++) {
            count[i] += count[i -1];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }
        return result;
    }
}
