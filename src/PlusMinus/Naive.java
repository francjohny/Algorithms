package PlusMinus;
import java.util.Arrays;
import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println((float) Arrays.stream(ar).filter(x -> x > 0).count() / n);
        System.out.println((float) Arrays.stream(ar).filter(x -> x < 0).count() / n);
        System.out.println((float) Arrays.stream(ar).filter(x -> x == 0).count() / n);
    }
}
