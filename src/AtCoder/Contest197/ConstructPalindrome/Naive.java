package AtCoder.Contest197.ConstructPalindrome;

import java.util.Scanner;

public class Naive {

    public static final int INF = (int) (1e6 + 5);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            char c = scanner.next().charAt(0);
            matrix[a][b] = c;
            matrix[b][a] = c;
        }
        int shortestLen = constructPalindrome(0, n - 1, n, matrix, 0, -1, n);
        System.out.println(shortestLen == INF ? -1 : shortestLen);
    }

    // FIXME: WA, TLE
    public static int constructPalindrome(int low, int high, int n, char[][] matrix, int len, int previousLow, int previousHigh) {
        if (low == high) {
            return len;
        }
        int shortestLen = INF;
        for (int i = 0; i < n; i++) {
            if (matrix[low][i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (matrix[high][j] == 0 || (i == previousLow && j == previousHigh)) continue;
                if (i == high && j == low) {
                    return len + 1;
                }
                if (matrix[low][i] == matrix[high][j]) {
                    int shortestPalindromeConstructed = constructPalindrome(i, j, n, matrix, len + 2, low, high);
                    shortestLen = Math.min(shortestPalindromeConstructed, shortestLen);
                }
            }
        }
        return shortestLen;
    }
}
