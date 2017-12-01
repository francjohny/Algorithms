package ArraysLeftRotation;

import java.util.Arrays;
import java.util.Scanner;

/*
 * A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
 * For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].
 * Given an array of n integers and a number, d, perform d left rotations on the array.
 * Then print the updated array as a single line of space-separated integers.
 *
 * Input:
 * 5 4
 * 1 2 3 4 5
 *
 * Output:
 * 5 1 2 3 4
 *
 * [1, 2, 3, 4, 5] -> [2, 3, 4, 5, 1] -> [3, 4, 5, 1, 2] -> [4, 5, 1, 2, 3] -> [5, 1, 2, 3, 4]
 */
public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
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
