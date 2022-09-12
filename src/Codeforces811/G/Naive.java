package Codeforces811.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
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
        int t = fastIO.getInt();
        while (t-- > 0) {
            int n = fastIO.getInt();
            ans = new long[n + 1];
            ans[1] = 0;
            ArrayDeque<Integer>[] graph = new ArrayDeque[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayDeque<>();
            }
            long[] a = new long[n + 1];
            long[] b = new long[n + 1];
            graph[1].add(0);
            for (int i = 2; i <= n; i++) {
                int p = fastIO.getInt();
                a[i] = fastIO.getInt();
                b[i] = fastIO.getInt();
                graph[i].add(p);
                graph[p].add(i);
            }
            dfs(1, 0, graph, a, b);
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                String last = " ";
                if (i == n) {
                    last = "";
                }
                sb.append(ans[i] + last);
            }
            System.out.println(sb);
        }
    }

    private static long[] ans;
    private static Stack<Long> stack = new Stack<>();

    private static int upper(Stack<Long> array, long target) {
        int low = 0, high = array.size();
        while (low < high) {
            int mid = (low + (high - low) / 2);
            if (array.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high - 1;
    }

    private static void dfs(int node, int parent, ArrayDeque<Integer>[] graph, long[] a, long[] b) {
        a[node] += a[parent];
        b[node] += b[parent];
        stack.push(b[node]);
        ans[node] = upper(stack, a[node]);
        for (int child: graph[node]) {
            if (child == parent) continue;
            dfs(child, node, graph, a, b);
        }
        a[node] -= a[parent];
        b[node] -= b[parent];
        stack.pop();
    }
}
