package Codeforces674.B;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int count = 0;
            boolean flag;
            int[][][] a = new int[n][2][2];
            for (int i = 0; i < n; i++) {
                a[i][0][0] = in.nextInt();
                a[i][0][1] = in.nextInt();
                a[i][1][0] = in.nextInt();
                a[i][1][1] = in.nextInt();
            }
            if (m % 2 != 0) {
                System.out.println("NO");
                continue;
            }
            for (int k = 0; k < n; k++) {
                flag = true;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (i != j) {
                            if (a[k][i][j] != a[k][j][i]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (flag) {
                    count++;
                }
                if (count > 0) {
                    break;
                }
            }
            if ((count > 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
