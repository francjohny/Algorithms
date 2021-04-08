package AtCoder.orxor197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int min = Integer.MAX_VALUE, or, xor;
        for (int i = 0; i < Math.pow(2, n - 1); i++) {
            or = 0;
            xor = 0;
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    or |= a[j];
                }
                if (j == n || ((i >> j & 1) == 1)) {
                    xor ^= or;
                    or = 0;
                }
            }
            min = Math.min(min, xor);
        }
        System.out.println(min);
    }
}
