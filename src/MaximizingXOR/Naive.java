package MaximizingXOR;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        for (int i = n; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int xor = i ^ j;
                if (xor > max)
                    max = xor;
            }
        }
        System.out.println(max);
    }
}
