package DiagonalDifference;

import java.util.Scanner;

public class OneDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = sc.nextInt();
            }
        }
        int sumL = 0, sumR = 0;
        for (int i = 0; i < n; i++) {
            sumL += arr[i * n + i];
            sumR += arr[(i * n) + n - i - 1];
        }
        System.out.println(Math.abs(sumL - sumR));
    }
}
