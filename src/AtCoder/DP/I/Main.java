package AtCoder.DP.I;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

class FastScanner {
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

public class Main {
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextDouble();
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(getProbabilityOfHeads(n, p));
        out.close();
    }

    private static double getProbabilityOfHeads(int n, double[] p) {
        double[] dp = new double[n + 1]; // dp[i] = probability of having i heads
        dp[0] = 1.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j >= 0; j--) {
//                System.out.println("----------" + j + "----------");
//                if ((j - 1) >= 0) {
//                    System.out.println(p[i] + "*" + dp[j - 1] + "+" + (1.0 - p[i]) + "*" + dp[j]);
//                }
//                else {
//                    System.out.println((1.0 - p[i]) + "*" + dp[j]);
//                }
                dp[j] = (((j - 1) >= 0) ? (p[i] * dp[j - 1]) : 0) + (1.0 - p[i]) * dp[j];
            }
//            System.out.println(Arrays.toString(dp));
        }
        double ans = 0.0;
        for (int i = 0; i <= n; i++) {
            int tails = n - i;
            if (i > tails) {
                ans += dp[i];
            }
        }
        return ans;
    }
}
