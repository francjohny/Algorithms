package leetcode.one.nine.seven.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    final long MOD = (int) 1e9 + 7;
    public int countPaths(int n, int[][] roads) {
        List<long[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road: roads) {
            int u = road[0], v = road[1], time = road[2];
            graph[u].add(new long[]{v, time});
            graph[v].add(new long[]{u, time});
        }
        return dijkstra(graph);
    }
    
    private int dijkstra(List<long[]>[] graph) {
        int n = graph.length;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        long[] ways = new long[n];
        ways[0] = 1;
        q.offer(new long[]{0, 0});
        while(!q.isEmpty()) {
            long[] node = q.poll();
            int u = (int) node[0];
            long d = node[1];
            if (d > dist[u]) {
                continue;
            }
            for(long[] adjNode: graph[u]) {
                int v = (int) adjNode[0];
                long time = adjNode[1];
                if(d + time < dist[v]) {
                    dist[v] = d + time;
                    ways[v] = ways[u];
                    q.offer(new long[]{v, dist[v]});
                } else if (dist[v] == d + time) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) ways[n - 1];
    }
}
