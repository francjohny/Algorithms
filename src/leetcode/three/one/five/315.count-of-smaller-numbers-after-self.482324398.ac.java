package leetcode.three.one.five;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, 0, n - 1);
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }
    
    private void merge(int[] nums, int[] indices, int start, int mid, int end) {
        int i = start, j = mid + 1, swaps = 0, k = 0;
        int[] indexClone = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[indices[j]] < nums[indices[i]]) {
                swaps++;
                indexClone[k++] = indices[j++];
            } else {
                count[indices[i]] += swaps;
                indexClone[k++] = indices[i++];
            }
        }
        while (i <= mid) {
            count[indices[i]] += swaps;
            indexClone[k++] = indices[i++];
        }
        while (j <= end) {
            indexClone[k++] = indices[j++];
        }
        for (int k1 = start; k1 <= end; k1++) {
            indices[k1] = indexClone[k1 - start];
        }
    }
    
    private void mergeSort(int[] nums, int[] indices, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, indices, low, mid);
        mergeSort(nums, indices, mid + 1, high);
        merge(nums, indices, low, mid, high);
    }
}
