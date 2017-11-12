package ArraysLeftRotation;

import java.util.Arrays;
import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        while (k-- > 0) {
            int temp = a[0];
            for (int i = 1; i < a.length; i++) {
                a[i - 1] = a[i];
            }
            a[a.length - 1] = temp;
        }
        Arrays.stream(a).forEach(elem -> System.out.print(elem + " "));
        System.out.println();
    }
}
