package leetcode.one.two.eight.three;

class Solution {
    
    private boolean holdsTrue(int[] nums, int mid, int threshold) {
        int sum = 0;
        for(int num: nums) {
            sum += Math.ceil(num / (double) mid);
        }
        return sum <= threshold;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1, high = (int) (1e6);
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (holdsTrue(nums, mid, threshold)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
