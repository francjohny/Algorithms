package ProductOfArrayExceptSelf;

import java.util.Arrays;
import java.util.Scanner;

/*
* Given an array of n integers where n > 1, nums,
* return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

* Solve it without division and in O(n).
* Input: [1, 2, 3, 4]
* Output: [24, 12, 8, 6]
* Time Complexity: O(n)
* Space Complexity: O(1)
*/
public class Better {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        int i, temp = 1;
        int output[] = new int[n];
        Arrays.fill(output, 1);

        for (i = 0; i < n; i++) {
            output[i] = temp;
            temp *= nums[i];
        }

        temp = 1;

        for (i = n - 1; i >= 0; i--) {
            output[i] *= temp;
            temp *= nums[i];
        }

        for (i = 0; i < n; i++)
            System.out.print(output[i] + " ");
    }
}
