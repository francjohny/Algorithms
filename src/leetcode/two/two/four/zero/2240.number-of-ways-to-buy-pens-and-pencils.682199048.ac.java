package leetcode.two.two.four.zero;

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 > total && cost2 > total) {
            return 1;
        }
        long sum = 0;
        long a1 = total / cost1;
        for(int i = 0; i <= a1; i++) {
            sum += (total - (i * cost1)) / cost2 + 1;
        }
        return sum;
    }
}
