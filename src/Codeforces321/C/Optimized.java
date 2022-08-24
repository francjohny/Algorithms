package Codeforces321.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Optimized {
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

    private static int ans = 0;
    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        int m = fastIO.getInt();
        int[] cats = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            cats[i] = fastIO.getInt();
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = fastIO.getInt() - 1;
            int v = fastIO.getInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, graph, -1, cats, 0, 0, m);
        System.out.println(ans);
    }

    private static void dfs(int currentNode, List<Integer>[] graph, int parent, int[] cats, int countCats, int maxCats, int m) {
        if (cats[currentNode] != 0) {
            countCats++;
        } else {
            countCats = 0;
        }
        maxCats = Math.max(maxCats, countCats);
        int numChildren = 0;
        for (int child : graph[currentNode]) {
            if (child != parent) {
                dfs(child, graph, currentNode, cats, countCats, maxCats, m);
                numChildren++;
            }
        }
        if (numChildren == 0 && maxCats <= m) ans++;
    }
}
