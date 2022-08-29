package Codeforces482.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    private final static int N = (int) 3e5 + 5;
    private static int[] subtrees = new int[N];
    private static boolean[] validSubtrees = new boolean[N];
    private static int dfs(int node, int parent, List<Integer>[] graph, int x) {
        subtrees[node] = 1;
        if (node == x) {
            validSubtrees[node] = true;
        } else {
            validSubtrees[node] = false;
        }
        for(int child: graph[node]) {
            if (child == parent) continue;
            subtrees[node] += dfs(child, node, graph, x);
            validSubtrees[node] |= validSubtrees[child];
        }
        return subtrees[node];
    }

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        int x = fastIO.getInt() - 1;
        int y = fastIO.getInt() - 1;
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = fastIO.getInt() - 1;
            int v = fastIO.getInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(y, -1, graph, x);
        int subtreeZ = 0;
        for (int z: graph[y]) {
            if (validSubtrees[z]) {
                subtreeZ = subtrees[y] - subtrees[z];
                break;
            }
        }
        System.out.println((long) n * (n - 1) - (long) subtreeZ * subtrees[x]);
    }
}
