package MaximumSubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Optimised {

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
            long maxSubArray = maxSubArray(arr);
            System.out.printf("%d %d", maxSubArray, sumOfSequence);
            System.out.println();
        }
    }


    private static long maxSubArray(long[] A) {
        int n = A.length;
        long[] sum = new long[n];
        sum[0] = A[0];
        long max = sum[0];

        for(int i = 1; i < n; i++){
            sum[i] = A[i] + (sum[i - 1] > 0 ? sum[i - 1] : 0);
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}
