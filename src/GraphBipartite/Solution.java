package GraphBipartite;

import java.util.HashMap;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        HashMap<Integer, Integer> colors = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!colors.containsKey(i) && !dfs(graph, colors, i, -1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, HashMap<Integer, Integer> colors, int node, int color) {
        if (colors.containsKey(node)) {
            return colors.get(node) == color;
        }
        colors.put(node, color);
        for (int i = 0; i < graph[node].length; i++) {
            if (!dfs(graph, colors, graph[node][i], color * -1)) {
                return false;
            }
        }
        return true;
    }
}