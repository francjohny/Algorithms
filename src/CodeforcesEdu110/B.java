package CodeforcesEdu110;

import java.math.BigInteger;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[n];
            boolean[] visited = new boolean[n];
            System.out.println(calculateGoodPairs(a, n, b, visited, 0));
        }
//        System.out.println(calculateGoodPairs(new int[]{3, 6, 5, 3}, 4, new int[]{6, 3, 5, 3}, new boolean[]{true, true, true, true}, 4));
    }

    private static int calculateGoodPairs(int[] a, int n, int[] b, boolean[] visited, int position) {
        int sum;
        if (position == n) {
            sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (gcd(b[i], b[j] * 2) > 1) {
                        sum++;
//                        System.out.println(b[i] + " " + b[j]);
                    }
                }
            }
            return sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                b[position] = a[i];
                visited[i] = true;
                sum = Math.max(sum, calculateGoodPairs(a, n, b, visited, position + 1));
                visited[i] = false;
                b[position] = 0;
            }
        }
        return sum;
    }


    private static int gcd(int i, int j) {
        BigInteger x = BigInteger.valueOf(i);
        BigInteger y = BigInteger.valueOf(j);
        return x.gcd(y).intValue();
    }
}
