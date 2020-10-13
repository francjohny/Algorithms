package Codeforces674.B;

import java.util.Scanner;

public class Optimized {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean flag = false;
            int[][][] a = new int[n][2][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        a[i][j][k] = in.nextInt();
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                flag |= a[k][1][0] == a[k][0][1];
            }
            flag &= (m % 2 == 0);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
