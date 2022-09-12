package leetcode.eight.zero;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, k = 2;
       for(int num: nums) {
           if (i < k || num > nums[i - k]) {
               nums[i++] = num;
           }
       }
        return i;
    }
}
