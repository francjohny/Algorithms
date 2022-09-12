package leetcode.two.two.four.two;

import java.util.PriorityQueue;

class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        PriorityQueue<Integer>[] q = new PriorityQueue[n];
        for(int i = 0; i < n; i++) {
            q[i] = new PriorityQueue<>((a, b) -> (scores[a] - scores[b]));
        }
        for(int[] edge: edges) {
            q[edge[0]].offer(edge[1]);
            q[edge[1]].offer(edge[0]);
            if (q[edge[0]].size() > 3) {
                q[edge[0]].poll();
            }
            if (q[edge[1]].size() > 3) {
                q[edge[1]].poll();
            }
        }
        int max = -1;
        for(int[] edge: edges) {
            for(int i: q[edge[0]]) {
                for(int j: q[edge[1]]) {
                    if (i != j && i != edge[1] && j != edge[0]) {
                        max = Math.max(max, scores[i] + scores[edge[0]] + scores[edge[1]] + scores[j]);
                    }
                }
            }
        }
        return max;
    }
}
