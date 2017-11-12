package AVeryBigSum;

import java.util.Arrays;
import java.util.Scanner;

/*
 * You are given an array of integers of size N.
 * You need to print the sum of the elements in the array, keeping in mind that some of those integers may be quite large.
 *
 * Input:
 * 5
 * 1000000001 1000000002 1000000003 1000000004 1000000005
 *
 * Output:
 * 5000000015
 */
public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        long result = Arrays.stream(arr).sum();
        System.out.println(result);
    }
}
