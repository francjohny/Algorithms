package Codeforces911.A;


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
            String s = io.next();
            int count = 0, blank = 0;
            for(char ch: s.toCharArray()) {
                if (ch == '.') {
                    count++;
                    blank++;
                } else if (ch == '#') {
                    count = 0;
                }
                if (count == 3) {
                    System.out.println(2);
                    break;
                }
            }
            if (count != 3)
                System.out.println(blank);
        }
    }
}
