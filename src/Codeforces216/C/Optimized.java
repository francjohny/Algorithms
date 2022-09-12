package Codeforces216.C;

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

    private static int[] problematicRoad;
    private static int[] badRoadCount;

    private static final int N = 300000 + 300;

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        badRoadCount = new int[N];
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        problematicRoad = new int[N];
        for (int i = 0; i < n - 1; i++) {
            int u = fastIO.getInt() - 1;
            int v = fastIO.getInt() - 1;
            int t = fastIO.getInt();
            if (t == 2) {
                problematicRoad[u] = 1;
                problematicRoad[v] = 1;
            }
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, -1, graph);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (problematicRoad[i] == 1 && badRoadCount[i] == 1) {
                ans.add(i + 1);
            }
        }
        System.out.println(ans.size());
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }

    private static void dfs(int root, int parent, List<Integer>[] graph) {
        badRoadCount[root] = problematicRoad[root];
        for(int child: graph[root]) {
            if (child != parent) {
                dfs(child, root, graph);
                badRoadCount[root] += badRoadCount[child];
            }
        }
    }
}
