package Codeforces790;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int candyCount = scanner.nextInt(), queries = scanner.nextInt();
        Integer[] arr = new Integer[candyCount];
        for (int i = 0; i < candyCount; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int[] prefix = new int[candyCount + 1];
        for (int i = 1; i <= candyCount; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        while (queries-- > 0) {
            System.out.println(check(scanner.nextInt(), prefix, candyCount));
        }
    }

    private static int check(int query, int[] prefix, int n) {
        int low = 1, high = n, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefix[mid] < query) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}
