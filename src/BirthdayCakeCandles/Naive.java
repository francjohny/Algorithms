package BirthdayCakeCandles;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long arr[] = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        long max = Arrays.stream(arr).mapToLong(x -> x).max().getAsLong();
        Map<Long, Long> countMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap.get(max));
    }
}
