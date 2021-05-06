package AtCoder.Contest199.Permutation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] x= new int[m];
        int[] y= new int[m];
        int[] z= new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            z[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        System.out.println(getPermutation(n, m, 0, dp, visited, x, y, z));
    }

    // iterating from i = 1 to n for each i (1 to n) and incrementally adding count of valid states in dp
    // dp - permutation (sequence of k+1 elements) e.g. 32100
    // count - count of values of a permutation assigned in dp
    private static long getPermutation(int n, int m, int count, int[] dp, boolean[] visited, int[] x, int[] y, int[] z) {
        if (count == n) {
            return 1;
        }
        long permutations = 0L;
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            if (visited[i - 1]) {
                continue;
            }
            // validation for current i with dp
            for (int j = 0; j < m; j++) {
                if ((x[j] >= count + 1) && (i <= y[j])) {
                    int violations = 1;
                    for (int k = 0; k < count; k++) {
                        if (dp[k] <= y[j]) {
                            violations++;
                        }
                    }
                    if (violations > z[j]) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                dp[count] = i;
                visited[i - 1] = true;
                permutations += getPermutation(n, m, count + 1, dp, visited, x, y, z);
                visited[i - 1] = false;
            }
        }
        return permutations;
    }
}
