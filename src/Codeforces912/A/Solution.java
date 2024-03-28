package Codeforces912.A;

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
        FastIO in = new FastIO();
        int t = in.getInt();
        while(t-- > 0) {
            int n = in.getInt();
            int k = in.getInt();
            int[] arr = new int[n];
            boolean isSorted = true;
            int prev = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.getInt();
                if (isSorted && arr[i] >= prev) {
                    prev = arr[i];
                } else {
                    isSorted = false;
                }
            }
            if (isSorted || k >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
