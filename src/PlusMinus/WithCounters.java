package PlusMinus;

import java.util.Scanner;

public class WithCounters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = 0, neg = 0, zero = 0;
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            int i1 = number > 0 ? pos++ : (number < 0 ? neg++ : zero++);
        }
        System.out.println((float) pos / n);
        System.out.println((float) neg / n);
        System.out.println((float) zero / n);
    }
}
