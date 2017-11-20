package Hourglass2DArray;

import java.util.Scanner;

/*
 * Given a 6x6 2D Array, A:
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 *
 * We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
 * a b c
 *   d
 * e f g
 *
 * There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
 *
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 6;
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int sum = calculateSum(a, i, j);
                if (sum > max)
                    max = sum;
            }
        }
        System.out.println(max);
    }

    private static int calculateSum(int[][] a, int i, int j) {
        return a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
    }
}
