package leetcode.three.three;

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int l = low;
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rotatedMid = (mid + l) % n;
            if (nums[rotatedMid] == target) {
                return rotatedMid;
            } else if (nums[rotatedMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
