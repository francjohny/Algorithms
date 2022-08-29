package CSES.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDistances2 {
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

    private static long[] count, sumDistance;

    private final static int N = (int) (2 * 1e5);

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        List<Integer>[] graph = new ArrayList[N];
        count = new long[N];
        sumDistance = new long[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = fastIO.getInt() - 1;
            int v = fastIO.getInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, -1, graph);
        dfs1(0, -1, n, graph);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sumDistance[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int u, int p, List<Integer>[] graph) {
        for (int v : graph[u]) {
            if (v != p) {
                dfs(v, u, graph);
                count[u] += count[v];
                sumDistance[u] += sumDistance[v] + count[v];
            }
        }
        count[u]++;
    }

    private static void dfs1(int u, int p, int n, List<Integer>[] graph) {
        for (int v : graph[u]) {
            if (v != p) {
                sumDistance[v] = sumDistance[u] - count[v] + n - count[v];
                dfs1(v, u, n, graph);
            }
        }
    }
}
