package leetcode.one.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return fourSum(nums, target, 4, 0);
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (index >= len) {
            return result;
        }
        if (k == 2) {
            // 2sum
            int low = index, high = len - 1;
            while(low < high) {
                 if (nums[low] + nums[high] == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[low], nums[high])));
                    while (low + 1 < len && nums[low] == nums[low + 1]) low++;
                    while (high > 0 && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] > target) {
                    high--;
                } else {
                    low++;
                }   
            }
        } else {
            for(int i = index; i < len; i++) {
                List<List<Integer>> list = fourSum(nums, target - nums[i], k - 1, i + 1);
                for(List<Integer> n: list) {
                    n.add(nums[i]);
                };
                result.addAll(list);
                while (i + 1 < len && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return result;
    }
}

// func(nums, k = 4, target) = [num1] + func(nums, k = 3, target - num1) = [num1, num2] + func(nums, k = 2, target - num1 - num2)
// func(nums, k = 2) 
// 1. sort
// 2. 2 pointers
// 3. [num3, num4]

// [num1, num2, num3, num4]
// TC: O(n^3)
// SC: O(n)
