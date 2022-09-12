package leetcode.one.zero.one.one;

import java.util.Arrays;

class Solution {
    private boolean canShip(int capacity, int[] weights, int days) {
        int total = 0, day = 1;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            if (total > capacity) {
                total = weights[i];
                day++;
                if (day > days) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        int n = weights.length;
        int max = Arrays.stream(weights).max().getAsInt();
        int low = max, high = sum;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (canShip(mid, weights, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
