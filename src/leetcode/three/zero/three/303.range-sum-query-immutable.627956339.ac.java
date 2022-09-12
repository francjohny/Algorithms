package leetcode.three.zero.three;

import java.util.Arrays;

class NumArray {

    int sum;
    int[] array;
    public NumArray(int[] nums) {
        int n = nums.length;
        array = Arrays.copyOf(nums, n);
        sum = 0;
        for(int num: nums) {
            sum += num;
        }
    }
    
    public int sumRange(int left, int right) {
        int temp = sum;
        for(int i = 0; i < left; i++) {
            temp -= array[i];
        }
        for (int j = array.length - 1; j > right; j--) {
            temp -= array[j];
        }
        return temp;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
