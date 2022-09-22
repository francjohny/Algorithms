package AtCoder.DP.M;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class Naive {
    static class FastScanner
    {
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

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(getNumberOfDifferentWaysToDistributeCandies(n, k, a));
        out.close();
    }

    private static final long MOD = (long) (1e9 + 7);

    private static long add(long a, long b) {
        return (a + b) % MOD;
    }
    private static long getNumberOfDifferentWaysToDistributeCandies(int n, int K, int[] a) {
        long[][] dp = new long[n + 1][K + 1]; // dp[i][j] = # of ways to distribute j candidates among first i children
        dp[0][0] = 1;
//        System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= K; j++) {
                for (int k = 0; k <= Math.min(j, a[i - 1]); k++) {
                    dp[i][j] = add(dp[i][j], dp[i - 1][j - k]);
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][K];
    }
}

// 3 children 3 candy
// - - -
// - 2 1
// - 1 2
// - - 3
// 1 1 1
// 1 - 2
// 1 2 -
