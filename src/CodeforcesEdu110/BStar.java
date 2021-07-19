package CodeforcesEdu110;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BStar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            List<Integer> b = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    b.add(a[i]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 1) {
                    b.add(a[i]);
                }
            }
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (gcd(b.get(i), b.get(j) * 2) > 1) {
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static int gcd(int i, int j) {
        BigInteger x = BigInteger.valueOf(i);
        BigInteger y = BigInteger.valueOf(j);
        return x.gcd(y).intValue();
    }
}
