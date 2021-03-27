package MaximumMedian;

import java.util.Arrays;
import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int i, inc, incUnit = 0;
        for (i = n / 2; i < n - 1; i++) {
            inc = (a[i + 1] - a[i]) * (i - n / 2 + 1);
            if (k > inc) {
                a[i] += inc;
                k -= inc;
            } else {
                incUnit = k / (i - n / 2 + 1);
                break;
            }
        }
        if (i == n - 1) {
            incUnit = k / (i - n / 2 + 1);
        }
        System.out.println(a[i] + incUnit);
    }
}