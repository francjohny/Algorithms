package BirthdayCakeCandles;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Optimised {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long arr[] = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr);
        long maxCount = Arrays.stream(arr).filter(x -> Objects.equals(x, arr[arr.length - 1])).count();
        System.out.println(maxCount);
    }
}
