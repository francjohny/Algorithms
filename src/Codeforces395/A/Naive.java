package Codeforces395.A;

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

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = fastIO.getInt() - 1;
            int v = fastIO.getInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = fastIO.getInt();
        }
        int root1 = -1, root2 = -1;
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                if (colors[i] != colors[j]) {
                    root1 = i;
                    root2 = j;
                    break;
                }
            }
        }
        if (root1 == -1 && root2 == -1) {
            System.out.println("YES");
            System.out.println(1);
            return;
        }
        if (go(root1, graph, colors)) {
            System.out.println("YES");
            System.out.println(root1 + 1);
        } else if (go(root2, graph, colors)) {
            System.out.println("YES");
            System.out.println(root2 + 1);
        } else {
            System.out.println("NO");
        }
    }

    private static boolean go(int root, List<Integer>[] graph, int[] colors) {
        for (int node : graph[root]) {
            if (!dfs(node, root, colors[node], graph, colors)) {
                return false;
            }
        }
        return true;
    }


    private static boolean dfs(int node, int parent, int currentColor, List<Integer>[] graph, int[] colors) {
        if (currentColor != colors[node]) {
            return false;
        }
        for (int child : graph[node]) {
            if (child != parent) {
                if (!dfs(child, node, currentColor, graph, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
