package CSES.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SubtreeQueries {
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

    static class SegmentTree {
        //Tlatoani's segment tree
        //iterative implementation = low constant runtime factor
        //range query, non lazy
        final long[] val;
        final int treeFrom;
        final int length;

        public SegmentTree(int treeFrom, int treeTo) {
            this.treeFrom = treeFrom;
            int length = treeTo - treeFrom + 1;
            int l;
            for (l = 0; (1 << l) < length; l++) ;
            val = new long[1 << (l + 1)];
            this.length = 1 << l;
        }

        public void update(int index, long delta) {
            //replaces value
            int node = index - treeFrom + length;
            val[node] = delta;
            for (node >>= 1; node > 0; node >>= 1)
                val[node] = comb(val[node << 1], val[(node << 1) + 1]);
        }

        public long query(int from, int to) {
            //inclusive bounds
            if (to < from)
                return 0; //0 or 1?
            from += length - treeFrom;
            to += length - treeFrom + 1; //0 or 1?
            long res = 0;
            for (; from + (from & -from) <= to; from += from & -from)
                res = comb(res, val[from / (from & -from)]);
            for (; to - (to & -to) >= from; to -= to & -to)
                res = comb(res, val[(to - (to & -to)) / (to & -to)]);
            return res;
        }

        public long comb(long a, long b) {
            //change this
            return a + b;
        }
    }


    private static int timer;
    private static int[] start;
    private static int[] end;
    private static List<Integer>[] graph;

    private static void dfs(int node, int parent) {
        start[node] = timer++;
        for (int child : graph[node]) {
            if (child != parent) {
                dfs(child, node);
            }
        }
        end[node] = timer - 1;
    }

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        PrintWriter out = new PrintWriter(System.out);
        int n = fastIO.getInt();
        int q = fastIO.getInt();
        graph = new ArrayList[n + 1];
        start = new int[n + 1];
        end = new int[n + 1];
        timer = 0;
        int[] val = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            val[i] = fastIO.getInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = fastIO.getInt();
            int b = fastIO.getInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1, 0);
        SegmentTree segmentTree = new SegmentTree(1, n + 1);
        for (int i = 1; i <= n; i++) {
            segmentTree.update(start[i], val[i]);
        }
        for (int i = 0; i < q; i++) {
            int query = fastIO.getInt();
            if (query == 1) {
                int s = fastIO.getInt();
                int value = fastIO.getInt();
                segmentTree.update(start[s], value);
            } else {
                // query = 2
                int s = fastIO.getInt();
                out.println(segmentTree.query(start[s], end[s]));
            }
        }
        out.close();
    }
}
