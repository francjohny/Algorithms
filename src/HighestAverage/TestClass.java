package HighestAverage;

import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
    private static int search(double avg[], int x) {
        int mid, low = 0, high = avg.length;
        while (low < high) {
            mid = (low + high) >> 1;
            if (avg[mid] < x) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int arr[] = new int[n];
        double avg[] = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            avg[i] = sum / (i + 1);
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int k = in.nextInt();
            System.out.println(search(avg, k));
        }
    }
}
