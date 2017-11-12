package DiagonalDifference;

import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int sumL = 0, sumR = 0;
        for (int i = 0; i < n; i++) {
            sumL += arr[i][i];
            sumR += arr[i][n - i - 1];
        }
        System.out.println(Math.abs(sumL - sumR));
    }
}
