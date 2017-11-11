package AddWithoutPlus;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int sum = add(a, b);
        System.out.println(sum);
    }

    /*Given 2 numbers
        a = 5           (0000 0000 0000 0101)
        b = 3           (0000 0000 0000 0011)
        a ^ b =         (0000 0000 0000 0110)   a
        (a & b) << 1 =  (0000 0000 0000 0010)   b

        a ^ b =         (0000 0000 0000 0100)   a
        (a & b) << 1 =  (0000 0000 0000 0100)   b

        a ^ b =         (0000 0000 0000 0000)   a
        (a & b) << 1 =  (0000 0000 0000 1000)   b

        a ^ b =         (0000 0000 0000 1000)   a
        (a & b) << 1 =  (0000 0000 0000 0000)   b

        a + b =         (0000 0000 0000 1000)   a
        -----------------------------------------
        a = 2           (0000 0000 0000 0010)
        b = 2           (0000 0000 0000 0010)
        a ^ b =         (0000 0000 0000 0000)   a
        (a & b) << 1 =  (0000 0000 0000 0100)   b

        a ^ b =         (0000 0000 0000 0100)   a
        (a & b) << 1 =  (0000 0000 0000 0000)   b

        a + b =         (0000 0000 0000 0100)   a
    */
    private static int add(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
}
