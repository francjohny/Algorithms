package leetcode.one.two.eight;// sequence
// longest
// consecutive
// unsorted
// O(n)

import java.util.HashSet;
import java.util.Set;

class Solution {
    
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i] - 1)) {
                int counter = nums[i] + 1;
                int streak = 1;
                while (set.contains(counter)) {
                    counter++;
                    streak++;
                }
                max = Math.max(streak, max);
            }
        }
        return max;
    }
}

// [100,4,200,1,3,2]
// 100  - group 1
//      99  not in set
//      101 not in set, max streak = 1


// 4
// 3 in set, continue (as the streak would start from a lower number)

// 200
// 199 not in set
// 201 not in set, max streak 1

// 1
// 0 not in set
// 2 in set
// 3 in set
// 4 in set
// 5 not in set, max streak = 4

// 3
// 2 in set, continue

// 2, 
// 1 in set, continue
