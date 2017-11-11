package Staircase;

import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++) {
            while(count++ < n - i - 1)
                System.out.print(" ");
            while(count++ <= n)
                System.out.print("#");
            System.out.println();
            count = 0;
        }
    }
}
