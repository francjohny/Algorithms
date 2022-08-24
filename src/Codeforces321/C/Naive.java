package Codeforces321.C;

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
        boolean[] visited = new boolean[n];
        System.out.println(dfs(0, graph, visited, cats, m));
    }
    private static int dfs(int currentNode, List<Integer>[] graph, boolean[] visited, int[] cats, int m) {
        visited[currentNode] = true;
        int ans = 0;
        if (currentNode != 0 && graph[currentNode].size() == 1) {
            return 1;
        }
        for(int child: graph[currentNode]) {
            if (visited[child]) {
                continue;
            }
            if (cats[currentNode] != 0 && cats[child] != 0) {
                cats[child] = cats[currentNode] + 1;
            }
            if (cats[child] > m) {
                continue;
            }
            ans += dfs(child, graph, visited, cats, m);
        }
        return ans;
    }
}
