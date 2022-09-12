package leetcode.seven.four.zero;

import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        // either you can delete a num or skip it
        // if delete, then you need to delete ALL nums - 1 and score = EVERY num
        // if dont delete, then skip it to the next num, and perform step 2 or 3 again
        // max score
        int n = 10001;
        Arrays.sort(nums);
        int[] count = new int[n];
        for(int num: nums) {
            count[num] += num;
        }
        int take = 0, skip = 0;
        for(int i = 0 ; i < n ; i++) {
            int prevTake = skip + count[i];
            int prevSkip = Math.max(skip, take);
            take = prevTake;
            skip = prevSkip;
        }
        return Math.max(take, skip);
    }
}


// 4 3 3 3 2 2 
// 4 4 4 4 6 6 (take 4, delete 3)
// 0 3 6 9 9 9 (skip 4, take 3, delete 2)
// 0 0 0 0 2 4 (skip 4, skip 3, take 2)
// 0 0 0 0 0 0 (skip 4, skip 3, skip 2)
