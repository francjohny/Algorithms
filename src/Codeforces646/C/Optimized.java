package Codeforces646.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Optimized {
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
        FastIO fastIO = new FastIO();
        int t = fastIO.getInt();
        while (t-- > 0) {
            int n = fastIO.getInt();
            int[] degree = new int[n];
            int x = fastIO.getInt() - 1;
            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = fastIO.getInt() - 1;
                int v = fastIO.getInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
                degree[u]++;
                degree[v]++;
            }
            if (degree[x] <= 1) {
                System.out.println("Ayush");
            } else {
                if (n % 2 == 0) {
                    System.out.println("Ayush");
                } else {
                    System.out.println("Ashish");
                }
            }
        }
    }
}
