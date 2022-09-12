package leetcode.five.zero.three;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n * 2; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}

