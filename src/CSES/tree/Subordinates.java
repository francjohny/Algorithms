package CSES.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Subordinates {
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
        for (int i = 1; i < n; i++) {
            int u = fastIO.getInt() - 1;
            graph[u].add(i);
        }
        int[] output = new int[n];
        dfs(0, -1, graph, output);
        System.out.println(Arrays.stream(output).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void dfs(int currentNode, int parent, List<Integer>[] graph, int[] output) {
        if (graph[currentNode].size() == 0) {
            return;
        }
        output[currentNode] += graph[currentNode].size();
        for(int node: graph[currentNode]) {
            if (node != parent) {
                dfs(node, currentNode, graph, output);
                output[currentNode] += output[node];
            }
        }
    }
}
