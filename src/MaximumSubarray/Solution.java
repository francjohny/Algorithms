package MaximumSubarray;

class Solution {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0], low = 0, high = 1, max = nums[0];
        while (high < n) {
            sum += nums[high];
            while (low < high && sum <= 0) {
                sum -= nums[low++];
            }
            max = Math.max(max, sum);
            high++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Solution.maxSubArray(new int[]{-2,3,1,3}));
    }
}