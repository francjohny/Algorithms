package Codeforces540.F1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Naive {
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

    private static int ans = 0;
    private static List<Integer> graph[];
    private static int[] a;

    private static int reds, blues;

    private static int[] dfs(int node, int parent) {
        int red = a[node] == 1 ? 1 : 0;
        int blue = a[node] == 2 ? 1 : 0;
        for (int child : graph[node]) {
            if (child != parent) {
                int[] pair = dfs(child, node);
                if (pair[0] == reds && pair[1] == 0) {
                    ans++;
                }
                if (pair[0] == 0 && pair[1] == blues) {
                    ans++;
                }
                red += pair[0];
                blue += pair[1];
            }
        }
        return new int[]{red, blue};
    }


    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fastScanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = fastScanner.nextInt();
            if (a[i] == 1) {
                reds++;
            } else if (a[i] == 2) {
                blues++;
            }
        }
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a1 = fastScanner.nextInt();
            int b1 = fastScanner.nextInt();
            graph[a1].add(b1);
            graph[b1].add(a1);
        }
        dfs(1, 0);
        out.println(ans);
        out.close();
    }
}
