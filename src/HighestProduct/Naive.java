package HighestProduct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Naive {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String strings[] = input.split(",");
        int numbers[] = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int max = getProduct(numbers, numbers.length);
        System.out.println(max);
    }

    private static int getProduct(int[] numbers, int n) {
        if (numbers.length < 3) {
            return -1;
        }
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1] * numbers[n - 1],
                numbers[n - 1] * numbers[n - 2] * numbers[n - 3]);
    }
}
