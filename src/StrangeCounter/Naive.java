package StrangeCounter;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long i, diff;
        for (i = 0, diff = 3; i < x; i += diff, diff *= 2);
        long j, k;
        for (j = i, k = 1; j >= x; j--, k++);
        System.out.println(k-1);
    }
}
