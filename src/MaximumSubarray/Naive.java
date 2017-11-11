package MaximumSubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    private static long max = Integer.MIN_VALUE;
    private static long sum = 0;
    public static void main(String[] args) {
        FastIO in = new FastIO();
        int t = in.getInt();
        while (t-- > 0) {
            int n = in.getInt();
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.getInt();
            }
            long[] positiveInts = Arrays.stream(arr).filter(value -> value > 0).toArray();
            long sumOfSequence = Arrays.stream(positiveInts).sum();
            if(positiveInts.length == 0) {
                sumOfSequence = Arrays.stream(arr).max().getAsLong();
            }
            calculateMaxSubArray(arr, 0, n - 1);
            System.out.printf("%d %d", max, sumOfSequence);
            System.out.println();
            sum = 0;
            max = Integer.MIN_VALUE;
        }
    }

    private static void calculateMaxSubArray(long[] arr, int i, int j) {
        if (i == arr.length)
            return;
        sum = Arrays.stream(arr, i, j + 1).sum();
        max = Math.max(sum, max);
        if ((j - i) == 0) {
            i = i + 1;
            j = arr.length;
        }
        calculateMaxSubArray(arr, i, j - 1);
    }

}
