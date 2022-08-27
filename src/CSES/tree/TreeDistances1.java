package CSES.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDistances1 {
    static class FastIO {
        private BufferedReader br;
        private StringTokenizer stringTokenizer;

        public FastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                    stringTokenizer = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringTokenizer.nextToken();
        }

        public int getInt() {
            return Integer.parseInt(next());
        }

        public long getLong() {
            return Long.parseLong(next());
        }

        public double getDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    private static int[][] distances;

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        distances = new int[2][200000];
        List<Integer>[] graph = new ArrayList[200000];
        for (int i = 0; i < 200000; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = fastIO.getInt() - 1;
            int v = fastIO.getInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        int a = dfs(0, -1, graph, 0, 0);
        int b = dfs(a, -1, graph, 0, 0);
        dfs(b, -1, graph, 0, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.max(distances[0][i], distances[1][i]) + 1).append(" ");
        }
        System.out.println(sb);
    }

    private static int dfs(int node, int parent, List<Integer>[] graph, int distance, int root) {
        distances[root][node] = distance;
        int i = -1;
        for (int child : graph[node]) {
            if (child != parent) {
                int j = dfs(child, node, graph, distance + 1, root);
                if (i == -1 || distances[root][j] > distances[root][i]) i = j;
            }
        }
        return i != -1 ? i : node;
    }
}
