package AtCoder.Contest199.Intersection;

import java.util.Scanner;

public class Main {

    public static final int INF = (int) (1e9 + 4);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int min = INF;
        int max = -INF;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            max = Math.max(max, a[i]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            min = Math.min(min, b[i]);
        }
        System.out.println(Math.max(min - max + 1, 0));
    }
}
