package Codeforces790;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    String a = strings[i], b = strings[j];
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        if (a.charAt(k) < b.charAt(k)) {
                            sum += b.charAt(k) - a.charAt(k);
                        } else if (a.charAt(k) > b.charAt(k)) {
                            sum += -b.charAt(k) +a.charAt(k);
                        }
                    }
                    min = Math.min(min, sum);
                }
            }
            System.out.println(min);
        }
    }
}
