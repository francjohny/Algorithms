package LonelyInteger;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Consider an array of n integers, A = [a0, a1, ... , an-1], where all but one of the integers occur in pairs.
  * In other words, every element in A occurs exactly twice except for one unique element.
 * Given A, find and print the unique element.
 *
 * Input 1:
 * n - denoting the number of integers
 * 1
 * 1
 * Output 1:
 * 1
 *
 * Input 2:
 * 3
 * 1 1 2
 * Output:
 * 2
 */
public class XOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        System.out.println(Arrays.stream(a).reduce((left, right) -> left ^ right).getAsInt());
    }
}
