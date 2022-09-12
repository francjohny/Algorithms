package leetcode.one.four.two.three;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, lsum = 0;
        for(int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }
        int max = lsum;
        for(int rsum = 0, i = 0; i < k; i++) {
            rsum += cardPoints[n - 1 - i];
            lsum -= cardPoints[k - 1 - i];
            max = Math.max(max, lsum + rsum);
        }
        return max;
    }
}
