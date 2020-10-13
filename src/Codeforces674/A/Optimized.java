package Codeforces674.A;

import java.util.Scanner;

public class Optimized {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            if (n < 3) {
                System.out.println(1);
            } else {
                n -= 2;
                System.out.println((n + x - 1) / x + 1);
            }
        }
    }
}
