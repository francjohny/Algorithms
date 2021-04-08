package AtCoderDP.D;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        // dp[i] - max possible sum of values for weight i
        long[] dp = new long[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w; j - weights[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[w]);
    }
}
