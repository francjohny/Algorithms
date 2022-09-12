package Codeforces665.D;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    private static int[] subtree;
    private static List<Integer>[] graph;

    private static final long MOD = (long) (1e9 + 7);

    private static void dfs(int node, int parent) {
        subtree[node] = 1;
        for (int child : graph[node]) {
            if (child != parent) {
                dfs(child, node);
                subtree[node] += subtree[child];
            }
        }
    }

    private static void sort(long[] arr) {
        //because sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Long> ls = new ArrayList<>();
        for (long x : arr)
            ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    private static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    private static long add(long a, long b) {
        return (a + b) % MOD;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fastScanner.nextInt();
        while (t-- > 0) {
            int n = fastScanner.nextInt();
            graph = new ArrayList[n];
            subtree = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int a = fastScanner.nextInt() - 1;
                int b = fastScanner.nextInt() - 1;
                graph[a].add(b);
                graph[b].add(a);
            }
            int kCount = fastScanner.nextInt();
            long[] v = new long[kCount];
            for (int i = 0; i < kCount; i++) {
                v[i] = fastScanner.nextLong();
            }
            sort(v);
            n--;
            long[] finalValues = new long[n];
            Arrays.fill(finalValues, 1);
            for (int i = kCount - 1; i >= 0; i--) {
                int index = Math.max(0, n - i - 1);
                finalValues[index] = mul(finalValues[index], v[i]);
            }
            dfs(0, -1);
            out.println("subtree = " + Arrays.toString(subtree));
            long[] edgeWeights = new long[n];
            for (int i = 1; i <= n; i++) {
                long times = subtree[i] * (long) (n + 1 - subtree[i]);
                edgeWeights[i - 1] = times;
            }
            sort(finalValues);
            sort(edgeWeights);
            out.println("edgeWeights = " + Arrays.toString(edgeWeights));
            out.println("finalValues = " + Arrays.toString(finalValues));
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = add(ans, mul(edgeWeights[i], finalValues[i]));
            }
            out.println(ans);
        }
        out.close();
    }
}
