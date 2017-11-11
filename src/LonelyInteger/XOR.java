package LonelyInteger;

import java.util.Arrays;
import java.util.Scanner;

public class XOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        System.out.println(Arrays.stream(a).reduce((left, right) -> left ^ right).getAsInt());
    }
}
