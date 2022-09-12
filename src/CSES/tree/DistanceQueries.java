package CSES.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class DistanceQueries {
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

    private static class LCA {
        public int N, root;
        public ArrayDeque<Integer>[] edges;
        private int[] enter;
        private int[] exit;

        private int[] depth;
        private int LOG = 17; //change this
        private int[][] dp;

        public LCA(int n, ArrayDeque<Integer>[] edges, int r) {
            N = n;
            root = r;
            enter = new int[N + 1];
            exit = new int[N + 1];
            depth = new int[N + 1];
            dp = new int[N + 1][LOG];
            this.edges = edges;
            int[] time = new int[1];
            //change to iterative dfs if N is large
            dfs(root, 0, time, 0);
            dp[root][0] = 1;
            depth[root] = 0;
            for (int b = 1; b < LOG; b++)
                for (int v = 1; v <= N; v++)
                    dp[v][b] = dp[dp[v][b - 1]][b - 1];
        }

        private void dfs(int curr, int par, int[] time, int d) {
            depth[curr] = d;
            dp[curr][0] = par;
            enter[curr] = ++time[0];
            for (int next : edges[curr])
                if (next != par)
                    dfs(next, curr, time, d + 1);
            exit[curr] = ++time[0];
        }

        public int lca(int x, int y) {
            if (isAnc(x, y))
                return x;
            if (isAnc(y, x))
                return y;
            int curr = x;
            for (int b = LOG - 1; b >= 0; b--) {
                int temp = dp[curr][b];
                if (!isAnc(temp, y))
                    curr = temp;
            }
            return dp[curr][0];
        }

        private boolean isAnc(int anc, int curr) {
            return enter[anc] <= enter[curr] && exit[anc] >= exit[curr];
        }
    }

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        int q = fastIO.getInt();
        ArrayDeque<Integer>[] edges = new ArrayDeque[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayDeque<>();
        }
        for (int i = 2; i <= n; i++) {
            int u = fastIO.getInt();
            int v = fastIO.getInt();
            edges[u].add(v);
            edges[v].add(u);
        }
        LCA lca = new LCA(n, edges, 1);
        for (int i = 0; i < q; i++) {
            int a = fastIO.getInt();
            int b = fastIO.getInt();
            int x = lca.lca(a, b);
            System.out.println(lca.depth[a] - lca.depth[x] + lca.depth[b] - lca.depth[x]);
        }
    }
}
