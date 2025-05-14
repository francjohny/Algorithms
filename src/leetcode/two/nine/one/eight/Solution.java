package leetcode.two.nine.one.eight;

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;
        for (int num : nums1) {
            if (num == 0) zero1++;
            sum1 += num;
        }
        for (int num : nums2) {
            if (num == 0) zero2++;
            sum2 += num;
        }
        long minSum1 = sum1 + zero1;
        long minSum2 = sum2 + zero2;
        if (minSum1 == minSum2) return minSum1;
        if (zero1 > 0 && zero2 > 0) return Math.max(minSum1, minSum2);
        if (zero1 == 0 && zero2 == 0) return -1;
        if (zero1 > 0) return minSum1 > minSum2 ? -1 : minSum2;
        return minSum2 > minSum1 ? -1 : minSum1;
    }
}