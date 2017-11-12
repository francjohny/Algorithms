package WomensCodeSprint4.ExtraSweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

// does not work for large data sets [unaccepted]
public class Naive {

    public static void main(String[] args) {
        FastIO in = new FastIO();
        Long n = in.getLong();
        Long s = in.getLong();
        long[] x = LongStream.range(0, n).toArray();
        for (int a0 = 0; a0 < s; a0++) {
            int l = in.getInt();
            int r = in.getInt();
            int[] arr = IntStream.range(l, r + 1).toArray();
            calculateSum(arr, x);
        }
    }

    private static void calculateSum(int[] sub, long[] main) {
        int sum = Arrays.stream(sub).sum();
        Arrays.stream(sub).forEach(x -> main[x] = Integer.MIN_VALUE);

        for (int i = sub[0] - 1; i >= 0; i--) {
            if (main[i] != Integer.MIN_VALUE) {
                sum += main[i];
                main[i] = Integer.MIN_VALUE;
                break;
            }
        }
        for (int i = sub[sub.length - 1] + 1; i < main.length; i++) {
            if (main[i] != Integer.MIN_VALUE) {
                sum += main[i];
                main[i] = Integer.MIN_VALUE;
                break;
            }
        }
        System.out.println(sum);
    }
}

class FastIO {
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

}
