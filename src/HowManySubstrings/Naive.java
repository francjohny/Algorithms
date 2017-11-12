package HowManySubstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Naive {

    public static class FastIO {
        private BufferedReader br;
        private StringTokenizer stringTokenizer;

        FastIO() {
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

    }

    private static long count = 0;
    private static int j_copy;
    private static HashMap<String, Integer> dic = new LinkedHashMap<>();

    public static void main(String[] args) {
        FastIO in = new FastIO();
        int n = in.getInt();
        int t = in.getInt();
        String str = in.next();
        while (t-- > 0) {
            int i = in.getInt();
            int j = in.getInt();
            j_copy = j;
            calculateNumberOfSubstrings(str, i, j);
            System.out.printf("%d\n", count + str.substring(i, j + 1).chars().distinct().count());
            count = 0;
            dic = new LinkedHashMap<>();
        }
    }

    private static void calculateNumberOfSubstrings(String str, int i, int j) {
        if (!dic.containsKey(str.substring(i, j + 1))) {
//            System.out.println(i + " " + j + " " + count + " " + str.substring(i, j + 1));
            if (i >= j_copy) {
                return;
            }
            count++;
            dic.put(str.substring(i, j + 1), 0);
        }
        if ((j - i) == 1 || (j - i) == 0) {
            i = i + 1;
            j = j_copy + 1;
        }
        calculateNumberOfSubstrings(str, i, j - 1);
    }
}
