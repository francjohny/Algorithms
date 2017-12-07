package BubbleSort;

import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        bubbleSort(a, n);
    }

    private static void bubbleSort(int[] a, int n) {
        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                if (a[j + 1] <= a[j]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }
            totalSwaps += numberOfSwaps;

            if (numberOfSwaps == 0) {
                break;
            }
        }
        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
    }
}
