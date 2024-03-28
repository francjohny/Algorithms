package Codeforces903.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
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
        FastIO io = new FastIO();
        int t = io.getInt();
        while(t-- > 0) {
            int n = io.getInt();
            int m = io.getInt();
            String s = io.next();
            String sub = io.next();
            if (s.contains(sub)) {
                System.out.println(0);
                continue;
            }
            System.out.println(check(s+s, sub, 1, n, m));
        }
    }

    private static int check(String s, String sub, int min, int n, int m) {
        if (s.contains(sub)) {
            return min;
        }
        if (n >= m * 2) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        min = check(sb.toString(), sub, ++min, sb.length(), m);
        return min;
    }
}
