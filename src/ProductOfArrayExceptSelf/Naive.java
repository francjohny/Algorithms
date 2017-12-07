package ProductOfArrayExceptSelf;

import java.util.Arrays;
import java.util.Scanner;


/*
* Given an array of n integers where n > 1, nums,
* return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

* Solve it without division and in O(n).
* Input: [1, 2, 3, 4]
* Output: [24, 12, 8, 6]
* Time Complexity: O(n^2)
*
* A rather naive solution would be to multiply all nums[i] except where i = j for each i,j=1,2,...,n in nums
*/
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int output[] = new int[n];
        Arrays.fill(output, 1);
        for (int i = 0, j = 0; j < nums.length; i = 0, j++) {
            while (++i < nums.length)
                if (i != j)
                    output[j] *= nums[i];
            System.out.print(output[j] + " ");
        }
    }
}
