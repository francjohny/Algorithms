package GraphBipartite;

import java.util.Arrays;

class Solt {
    public static boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        int[] colors = new int[m];
        Arrays.fill(colors, 2);
        for(int i = 0; i < m; i++) {
            if (colors[i] == 2) {
                colors[i] = 0;
                if (!dfs(graph, colors, i, 0)) {// 0 - red, 1 - blue
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int node, int color) {
        for(int child: graph[node]) {
            if(colors[child] != 2 && colors[child] == colors[node]) return false;
            if(colors[child] == 2) {
                colors[child] = (color^ 1);
                if (!dfs(graph, colors, child, color ^ 1))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}));
    }
}
