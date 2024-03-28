package Codeforces158.A;

import java.io.*;
import java.util.*;

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
            int k = io.getInt();
            int[] a = new int[n];
            int prev = 0, max = 0;
            for (int i = 0; i < n; i++) {
                a[i] = io.getInt();
                if ((a[i] - prev) > max) {
                    max = (a[i] - prev);
                }
                prev = a[i];
            }
            max = Math.max(max, Math.max(a[0], 2 * (k - a[n - 1])));
            System.out.println(max);
        }
    }
}
