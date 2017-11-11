package Spiral;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of spiral; i.e. number of columns, number of rows, or square root of last value: ");
        int n = in.nextInt();
        int[][] P = new int[n][n];

        int s = n * n;
        int i = 0, j = 0, di = 0, dj = 1, L = 0, a;
        for (a = 1; a <= s; a++) {
            if (i == L && j == (n - 1) - L) {
                di = 1;
                dj = 0;
            } else if (i == (n - 1) - L && j == (n - 1) - L) {
                di = 0;
                dj = -1;
            } else if (i == (n - 1) - L && j == L) {
                di = -1;
                dj = 0;
            } else if (i == 1 + L && j == L) {
                di = 0;
                dj = 1;
                L++;
            }

            P[i][j] = a;
            i += di;
            j += dj;
        }

        System.out.println();
        for (a = 0; a < s; a++) {
            System.out.print(P[a / n][a % n] + "\t");
            if ((a + 1) % n == 0) System.out.print("\n");
        }
        System.out.println();
    }
}
