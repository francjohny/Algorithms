package CodeforcesEdu110;

import java.util.Scanner;

public class AStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int[] s = new int[4];
            for (int j = 0; j < 4; j++) {
                s[j] = scanner.nextInt();
            }
            if (Math.min(s[0], s[1]) > Math.max(s[2], s[3]) || Math.max(s[0], s[1]) < Math.min(s[2], s[3])) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
