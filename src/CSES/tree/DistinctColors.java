package CSES.tree;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctColors {
    static class FastScanner {
        //I don't understand how this works lmao
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }

    private static void dfs(List<Integer>[] graph, Set<Integer>[] colors, int node, int parent, int[] output) {
        for(int child: graph[node]) {
            if (child != parent) {
                dfs(graph, colors, child, node, output);
                if (colors[node].size() < colors[child].size()) {
                    swap(colors[node], colors[child]);
                }
                for (int color :
                        colors[child]) {
                    colors[node].add(color);
                }
            }
        }
        output[node] = colors[node].size();
    }

    private static void swap(Set<Integer> color, Set<Integer> color1) {
        Set<Integer> temp = new HashSet<>(color);
        color.clear();
        color.addAll(color1);
        color1.clear();
        color1.addAll(temp);
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner();
        int n = fastScanner.nextInt();
        Set<Integer>[] colors = new HashSet[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = new HashSet<>();
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            colors[i].add(fastScanner.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = fastScanner.nextInt();
            int b = fastScanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] output = new int[n + 1];
        dfs(graph, colors, 1, 0, output);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(output[i]).append(" ");
        }
        out.println(sb);
        out.close();
    }
}
