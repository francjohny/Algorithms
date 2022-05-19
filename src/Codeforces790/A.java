package Codeforces790;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0) {
            String s = scanner.next();
            int firstSum = 0;
            for(int i = 0 ; i < s.length(); i++) {
                if (i < s.length() / 2)
                    firstSum += s.charAt(i) - '0';
                else
                    firstSum -= s.charAt(i) - '0';
            }
            System.out.println(firstSum == 0 ? "YES" : "NO");
        }
    }
}
