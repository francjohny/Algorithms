package leetcode.one.five.three.nine;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] - mid - 1 < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + k;
    }
}
