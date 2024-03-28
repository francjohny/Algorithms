package Codeforces906.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.getInt();
            }
            Arrays.sort(a);
            int[] b = new int[n];
            for (int i = 0, low = 0, high = n - 1; i < n; i++) {
                if (i % 2 == 0) {
                    b[i] = a[low++];
                } else {
                    b[i] = a[high--];
                }
            }

            boolean result = check(b, n);
            if (result) {
                System.out.println("YES");
            } else {
                for (int i = 0, low = 0, high = n - 1; i < n; i++) {
                    if (i % 2 == 0) {
                        b[i] = a[high--];
                    } else {
                        b[i] = a[low++];
                    }
                }
                result = check(b, n);
                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean check(int[] b, int n) {
        int sum = b[0] + b[1];
        for (int i = 0; i < n - 1; i++) {
            if (b[i] + b[i + 1] != sum) {
                return false;
            }
        }
        return true;
    }

}
