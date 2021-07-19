package CodeforcesEdu110;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int[] s = new int[4];
            for (int j = 0; j < 4; j++) {
                s[j] = scanner.nextInt();
            }
            int l1, l2;
            if (s[0] > s[1]) {
                l1 = 0;
                l2 = 1;
            } else {
                l1 = 1;
                l2 = 0;
            }
            for (int j = 2; j < 4; j++) {
                if (s[j] > s[l1]) {
                    l2 = l1;
                    l1 = j;
                } else if (s[j] > s[l2]) {
                    l2 = j;
                }
            }
            if ((l1 - 1.5) * (l2 - 1.5) < 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
