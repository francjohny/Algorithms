package leetcode.one.four.seven.five;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
