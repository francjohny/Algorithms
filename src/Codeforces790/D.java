package Codeforces790;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int sum = 0;
                    int ci = i, cj = j;
                    while (ci >= 0 && ci < n && cj >= 0 && cj < m) {
                        sum += a[ci][cj];
                        ci--;
                        cj--;
                    }
                    ci = i;
                    cj = j;
                    while (ci >= 0 && ci < n && cj >= 0 && cj < m) {
                        sum += a[ci][cj];
                        ci++;
                        cj--;
                    }
                    ci = i;
                    cj = j;
                    while (ci >= 0 && ci < n && cj >= 0 && cj < m) {
                        sum += a[ci][cj];
                        ci--;
                        cj++;
                    }
                    ci = i;
                    cj = j;
                    while (ci >= 0 && ci < n && cj >= 0 && cj < m) {
                        sum += a[ci][cj];
                        ci++;
                        cj++;
                    }
                    sum -= a[i][j] * 3;
                    max = Math.max(max, sum);
                }
            }
            System.out.println(max);
        }
    }
}
