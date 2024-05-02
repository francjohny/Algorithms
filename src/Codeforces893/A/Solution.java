package Codeforces893.A;

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
            int a = io.getInt();
            int b = io.getInt();
            int c = io.getInt();
            getResult(a, b, c);
        }
    }

    private static void getResult(int a, int b, int c) {
        if (c % 2 == 0) {
            System.out.println(a > b ? "First" : "Second");
        } else {
            System.out.println((b > a) ? "Second" : "First");
        }
    }
}
