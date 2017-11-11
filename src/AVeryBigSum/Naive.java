package AVeryBigSum;

import java.util.Arrays;
import java.util.Scanner;

public class Naive {

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(ar);
        System.out.println(result);
    }
}
