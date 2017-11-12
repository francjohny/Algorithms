package BirthdayCakeCandles;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Colleen is turning n years old! Therefore, she has n candles of various heights on her cake, and candle i has height height[i].
 * Because the taller candles tower over the shorter ones, Colleen can only blow out the tallest candles.
 * Given the height[i] for each individual candle, find and print the number of candles she can successfully blow out.
 *
 * Input:
 * 4
 * 3 2 1 3
 *
 * Output:
 * 2
 */
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
