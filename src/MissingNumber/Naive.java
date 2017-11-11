package MissingNumber;

import java.util.Scanner;

/* Given an array containing integers from [0 ... n] except for one number.
 * Find the missing number
 *
 * Input:
 * 4
 * 0 1 3 4
 *
 * Output:
 * 2
 *
 * Some interesting properties of XOR:
 * 1) 1 ^ 1 = 0 ^ 0 = 0
 * 2) 1 ^ 0 = 0 ^ 1 = 1
 * 3) xor of first n integers = [n, 1, n+1, 0] if n%4 = [0,1,2,3] respectively
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), i = n, arr[] = new int[n];
        while(i-- > 0) {
            arr[i] = in.nextInt();
        }
        i = n;
        while (i-- > 0) {
            n ^= arr[i] ^ i;
        }
        System.out.println(n);
    }
}
