package MiniMaxSum;

import java.util.Arrays;
import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] =  in.nextLong();
        }
        Arrays.sort(arr);
        System.out.println(getSum(arr, 0, 4) + " " + getSum(arr, 1, 5));
    }

    private static long getSum(long[] arr, int i, int j) {
        return Arrays.stream(arr, i, j).sum();
    }
}
