package CodeforcesEdu73;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while(q-- > 0) {
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num <= 2048) {
                    sum += num;
                }
            }

            if (sum >= 2048) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
