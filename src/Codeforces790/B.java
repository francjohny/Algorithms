package Codeforces790;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE, sum = 0, count = 0;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = scanner.nextInt();
                min = Math.min(min, arr[i]);
                sum += arr[i];
            }
            for(int i = 0 ; i < n; i ++) {
                if (arr[i] > min) {
                    count++;
                }
            }
            System.out.println(sum - (min * (n - count)) - (min * count));
        }
    }
}
