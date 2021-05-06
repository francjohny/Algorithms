package AtCoder.DP.D;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        long[] dp = new long[w + 1];
        for (int i = 0; i < n; i++) {
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            // dp[i] - max possible sum of values for weight i
            for (int j = w - weight; j >= 0; j--) {
                dp[j + weight] = Math.max(dp[j + weight], dp[j] + value);
            }
        }
        System.out.println(Collections.max(Arrays.stream(dp).boxed().collect(Collectors.toList())));
    }
}
