package AtCoder.DP.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] costs = new int[3];
        int[] happiness = new int[3];
        for (int i = 0; i < n; i++) {
            int[] dp = new int[3];
            for (int j = 0; j < 3; j++) {
                costs[j] = scanner.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[k] = Math.max(dp[k], happiness[j] + costs[k]);
                    }
                }
            }
            happiness = dp;
        }
        System.out.println(Math.max(happiness[0], Math.max(happiness[1], happiness[2])));
    }
}
