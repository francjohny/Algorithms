package leetcode.one.five.five.two;

import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = (int) (1e9);
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (canPlaceBalls(position, m, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int targetForce) {
        int lastPos = position[0], ballsLeft = m - 1;
        for(int i = 0; i < position.length && ballsLeft != 0; i++) {
            if (position[i] - lastPos >= targetForce) {
                ballsLeft--;
                lastPos = position[i];
            }
        }
        return ballsLeft == 0;
    }
}


// e.g.
// [1 ,2, 7]
// [1, 5, 6] = |x-y|
// min = 1

// [1, 3, 7]
// [2, 4, 6]
// min = 2

// [1, 4, 7]
// [3, 3, 6]
// min = 3

// input: set of basket positions, and no. of balls
// output: can you get a min magnetic force which is the greatest

// algo:
// 1. try to put m balls in all basket positions...O(ncm)
// 2. get the min magnetic force = min i O(1)
// max=max(max, mini) for all i in range 0 to positions - 1 O(1)
// TC: ncm ways (no. of unique ways)

// 1 2 7 
// 1 3 7
// 14 7
// 2 3 4
// 2 3 7
// 3 4 7

// approach 2:
// binary search
// sort(positions)
// what divides the array into left and right
// [left.....mid....right]
// |x-y| for all mids
// min



















