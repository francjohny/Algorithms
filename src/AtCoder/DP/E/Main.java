package AtCoder.DP.E;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final long INF = (long) (1e11 + 5);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        long[] dp = new long[n * 1000 + 1]; // or take sum of all values + 1
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            long weight = scanner.nextInt();
            int value = scanner.nextInt();
            // dp[i] - min possible weight for the value i
            for (int j = n * 1000; j >= value; j--) {
                dp[j] = Math.min(dp[j], dp[j - value] + weight);
            }
//            System.out.println(Arrays.toString(dp));
        }
        long ans = 0;
        for (int i = 0; i <= n * 1000; i++) {
            if (dp[i] <= w) {
                ans = Math.max(ans, i);
            }
        }
        System.out.println(ans);
    }
}
