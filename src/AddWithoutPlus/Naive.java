package AddWithoutPlus;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * Given 2 numbers x, y
 * Print the sum of x and y without using the `+` operator
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        BigInteger sum = add(a, b);
        System.out.println(sum);
    }

    /*
     * Given 2 numbers a and b
     * sum(without carry) = a ^ b
     * carry = (a & b) << 1
     * a = sum
     * b = carry
     * repeat till b = 0
     * sum = a
     * Example 1:
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

     *  a + b = 8       (0000 0000 0000 1000)   a

     * Example 2:
        a = 2           (0000 0000 0000 0010)
        b = 2           (0000 0000 0000 0010)
        a ^ b =         (0000 0000 0000 0000)   a
        (a & b) << 1 =  (0000 0000 0000 0100)   b

        a ^ b =         (0000 0000 0000 0100)   a
        (a & b) << 1 =  (0000 0000 0000 0000)   b

     *  a + b = 4       (0000 0000 0000 0100)   a
     */
    private static BigInteger add(BigInteger a, BigInteger b) {
        if (b.signum() == 0)
            return a;
        BigInteger sum = a.xor(b);
        BigInteger carry = (a.and(b)).shiftLeft(1);
        return add(sum, carry);
    }
}
