package Codeforces674.A;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int start = 3, floor = 2;
            if (n < start) {
                System.out.println(1);
            } else {
                while (true) {
                    int end = start + x;
                    if (n >= start && n < end) {
                        System.out.println(floor);
                        break;
                    } else {
                        floor++;
                        start = end;
                    }
                }
            }
        }
    }
}
