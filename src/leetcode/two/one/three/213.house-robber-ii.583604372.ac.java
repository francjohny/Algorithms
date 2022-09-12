package leetcode.two.one.three;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0], b = Math.max(a, nums[1]);
        for (int i = 2; i < n - 1; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        int c = nums[1], d = Math.max(c, nums[2]);
        for (int i = 3; i < n; i++) {
            int e = Math.max(d, c + nums[i]);
            c = d;
            d = e;
        }
        return Math.max(b, d);
    }
}
