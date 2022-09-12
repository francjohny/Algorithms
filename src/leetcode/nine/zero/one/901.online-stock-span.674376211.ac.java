package leetcode.nine.zero.one;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    
    Deque<int[]> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int cost = 1;
        while (!stack.isEmpty() && stack.getLast()[0] <= price) {
            // System.out.println(stack.getLast()[0] + " " + stack.getLast()[1]);
            cost += stack.removeLast()[1];
        }
        stack.offerLast(new int[]{price, cost});
        return cost;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 


 0   1. 2. 3.  4. 5. 6
[100,80,60,70,60,75,85]




75 4
80 1
100 1


*/
