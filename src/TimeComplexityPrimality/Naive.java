package TimeComplexityPrimality;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-- > 0) {
            boolean isPrime = checkPrime(in.nextInt());
            if (isPrime)
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }

    private static boolean checkPrime(int number) {
        if (number == 1)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
