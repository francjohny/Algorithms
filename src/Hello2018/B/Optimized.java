package Hello2018.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int n = fastIO.getInt();
        int[] parent = new int[n];
        int[] degree = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = fastIO.getInt() - 1;
            degree[parent[i]]++;
        }
        int[] leafCount = new int[n];
        for (int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                leafCount[parent[i]]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (degree[i] > 0 && leafCount[i] < 3) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
