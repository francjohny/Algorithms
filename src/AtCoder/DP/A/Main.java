package AtCoder.DP.A;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        final int INF = (int) (1e9 + 5);
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + 2 && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(a[j] - a[i]));
            }
        }
        System.out.println(dp[n - 1]);
    }
}
