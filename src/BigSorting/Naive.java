package BigSorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Consider an array of numeric strings, unsorted, where each string is a positive number with anywhere from 1 to 10^6 digits.
 * Sort the array's elements in non-decreasing order of their real-world integer values and print each element of the sorted array on a new line.
 *
 * Input:
 * 6
 * 31415926535897932384626433832795
 * 1
 * 3
 * 10
 * 3
 * 5
 *
 * Output:
 * 6
 * 31415926535897932384626433832795
 * 1
 * 3
 * 10
 * 3
 * 5
 */
public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.next();
        }
        Arrays.stream(unsorted).map(BigInteger::new).sorted().forEach(System.out::println); // impulsive decision but pretty slow
    }
}
