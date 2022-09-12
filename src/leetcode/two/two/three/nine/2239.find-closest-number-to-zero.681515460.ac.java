package leetcode.two.two.three.nine;

class Solution {
    public int findClosestNumber(int[] nums) {
        int smallestNeg = Integer.MIN_VALUE, smallestPos = Integer.MAX_VALUE;
        for(int num: nums) {
            if (num < 0) { 
                smallestNeg = Math.max(smallestNeg, num);
            } else if (num >= 0) {
                smallestPos = Math.min(smallestPos, num);
            }
        }
        if (smallestNeg != Integer.MIN_VALUE && Math.abs(smallestPos) > Math.abs(smallestNeg)) {
            return smallestNeg;
        }
        return smallestPos;
    }
}
