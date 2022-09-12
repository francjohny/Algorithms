package Codeforces130.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Naive {
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

    private static final int LOG = 17;

    private static int[][] dp;

    private static int[] depth;
    private static int[] enter;
    private static int[] exit;

    private static List<Integer>[] depthToNodesMap;

    static class LCA {
        public int N, root;
        public ArrayDeque<Integer>[] edges;

        public LCA(int n, ArrayDeque<Integer>[] edges, int r) {
            N = n;
            root = r;
            enter = new int[N + 1];
            exit = new int[N + 1];
            depth = new int[N + 1];
            depthToNodesMap = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                depthToNodesMap[i] = new ArrayList<>();
            }
            dp = new int[N + 1][LOG];
            this.edges = edges;
            int[] time = new int[1];
            //change to iterative dfs if N is large
            dfs(root, 0, time, 0);
            dp[root][0] = 1;
            for (int b = 1; b < LOG; b++)
                for (int v = 1; v <= N; v++)
                    dp[v][b] = dp[dp[v][b - 1]][b - 1];
        }

        private void dfs(int curr, int par, int[] time, int d) {
            depth[curr] = d;
            enter[curr] = ++time[0];
            depthToNodesMap[d].add(curr);
            dp[curr][0] = par;
            for (int next : edges[curr])
                if (next != par)
                    dfs(next, curr, time, d + 1);
            exit[curr] = ++time[0];
        }
    }

    private static int lower(int time, List<Integer> a) {
        int l = 0;
        int r = a.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (enter[a.get(mid)] <= time) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        ArrayDeque<Integer>[] edges = new ArrayDeque[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayDeque<>();
        }
        for (int i = 1; i <= n; i++) {
            int u = fastIO.getInt();
            edges[u].add(i);
            edges[i].add(u);
        }
        new LCA(n, edges, 0);
        int q = fastIO.getInt();
        while (q-- > 0) {
            int node = fastIO.getInt();
            int k = fastIO.getInt();
            int u = getKthAncestor(node, k);
            if (u == 0) {
                System.out.print(0 + " ");
            } else {
                System.out.print(lower(exit[u], depthToNodesMap[depth[u] + k]) - lower(enter[u], depthToNodesMap[depth[u] + k]) - 1 + " ");
            }
        }
    }

    private static int getKthAncestor(int node, int k) {
        if (depth[node] < k) {
            return 0;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (k >= (1 << i)) {
                node = dp[node][i];
                k -= (1 << i);
            }
        }
        return node;
    }
}
