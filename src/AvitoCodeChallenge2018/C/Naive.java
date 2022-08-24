package AvitoCodeChallenge2018.C;

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
    private static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        FastIO scanner = new FastIO();
        int n = scanner.getInt();
        List<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.getInt() - 1;
            int v = scanner.getInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        int intersection = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] > 2) {
                count++;
                intersection = Math.max(i, intersection);
            }
        }
        if (count > 1) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
        dfs(intersection, -1, graph);
        System.out.println(ans.size());
        for (int leaf : ans) {
            System.out.println((intersection + 1) + " " + (leaf + 1));
        }
    }

    private static void dfs(int intersection, int parent, List<Integer>[] graph) {
        boolean leaf = true;
        for (int node : graph[intersection]) {
            if (node == parent) {
                continue;
            }
            leaf = false;
            dfs(node, intersection, graph);
        }
        if (leaf) {
            ans.add(intersection);
        }
    }
}
