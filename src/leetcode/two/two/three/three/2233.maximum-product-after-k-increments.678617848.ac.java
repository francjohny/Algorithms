package leetcode.two.two.three.three;

import java.util.PriorityQueue;

class Solution {
    
    final long MOD = (long) (1e9 + 7);
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.offer(num);
        }
        while(k-- > 0) {
            int x = pq.peek();
            pq.poll();
            x += 1;
            pq.offer(x);
        }
        long result = 1;
        while(!pq.isEmpty()) {
            result = (result * pq.poll()) % MOD;
        }
        return (int) result;
    }
}
