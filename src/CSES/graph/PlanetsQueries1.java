package CSES.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlanetsQueries1 {
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

    private static int[][] dp;
    private static int LOG = 30; //change this

    private static int getKthAncestor(int node, int k) {
        for (int i = LOG - 1; i >= 0; i--) {
            if (k >= (1 << i)) {
                node = dp[node][i];
                k -= (1 << i);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        int q = fastIO.getInt();

        int N = (int) (2e5+5);

        dp = new int[N][LOG];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = fastIO.getInt();
        }
        for (int b = 1; b < LOG; b++)
            for (int v = 1; v <= n; v++)
                dp[v][b] = dp[dp[v][b - 1]][b - 1];

        for (int i = 0; i < q; i++) {
            System.out.println(getKthAncestor(fastIO.getInt(), fastIO.getInt()));
        }
    }
}
