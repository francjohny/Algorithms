package Codeforces892.A;

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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = io.getInt();
            }
            Arrays.sort(arr);
            getResult(n, arr);
        }
    }

    private static void getResult(int n, int[] arr) {
        if (arr[0] == arr[n-1]) {
            System.out.println(-1);
        } else {
            int iter = 0;
            while (arr[iter] == arr[iter+1]) {
                iter++;
            }
            System.out.println((iter + 1) + " " + (n - iter - 1));
            for (int i = 0; i <= iter; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            for (int i = iter + 1; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
