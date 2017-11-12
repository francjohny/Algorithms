package CoinChange;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * Given a number of dollars, n, and a list of dollar values for m distinct coins, C={c[0], c[1], c[2], c[3], ... , c[m-1]}
 * Find and print the number of different ways you can make change for n dollars **if each coin is available in an infinite quantity.**
 *
 * Think about the degenerate cases:
 * How many ways can you make change for 0 dollars?
 * How many ways can you make change for less than 0 dollars if you have no coins?
 *
 * Input:
 * n m
 * 4 3
 * 1 2 3
 *
 * Output:
 * 4
 */
public class Naive {

    /*
     * Example 1:
     * quarter = 25 cents, dime = 10 cents, nickel = 5 cents, penny = 1 cent
     * Find the number of ways of making change of 100
     * Lets start with the highest denomination, quarters = 25 cents, then dimes, then nickels and finally pennies, the smallest of the lot
     * Squeeze till you get the maximum number of coins you can make with a denomination
     * Else divide the amount/problem into smaller amounts/suboptimal problems
     * quarters = 25 cents
       makeChange(100) = makeChange(100 using 0 quarters) + makeChange(100 using 1 quarters) + ... + makeChange(100 using 100/quarter quarters)
       makeChange(100) = makeChange(100 using 0 quarters) + makeChange(75 using 0 quarters) + ... + 1

     * dimes = 10 cents
       makeChange(100 using 0 quarters) = makeChange(100 using 0 quarters, 0 dimes) + makeChange(100 using 0 quarters, 1 dimes) + ... + makeChange(100 using 0 quarters, 100/dime dimes)
       makeChange(100 using 0 quarters) = makeChange(100 using 0 quarters, 0 dimes) + makeChange(90 using 0 quarters, 0 dimes) + ... + 1

     * nickels = 5 cents
       makeChange(100 using 0 quarters, 0 dimes) = makeChange(100 using 0 quarters, 0 dimes, 0 nickels) + makeChange(100 using 0 quarters, 0 dimes, 1 nickels) + ... + makeChange(100 using 0 quarters, 0 dimes, 100/nickel nickels)
       makeChange(100 using 0 quarters, 0 dimes) = makeChange(100 using 0 quarters, 0 dimes, 0 nickels) + makeChange(95 using 0 quarters, 0 dimes, 0 nickels) + ... + 1

    * pennies = 1 cent
       makeChange(100 using 0 quarters, 0 dimes, 0 nickels) = makeChange(100 using 0 quarters, 0 dimes, 0 nickels, 0 pennies) + makeChange(100 using 0 quarters, 0 dimes, 0 nickels, 1 pennies) + ... + makeChange(100 using 0 quarters, 0 dimes, 0 nickels, 100/penny pennies)
       makeChange(100 using 0 quarters, 0 dimes, 0 nickels) = makeChange(100 using 0 quarters, 0 dimes, 0 nickels, 0 pennies) + makeChange(99 using 0 quarters, 0 dimes, 0 nickels, 0 pennies) + ... + 1
       ...
     */
    static long getWays(long n, Long[] denoms, int index) {
        if (index >= denoms.length - 1) {
            if (n % denoms[index] == 0)
                return 1;
            return 0;
        }
        Long denomination = denoms[index];
        long ways = 0;
        for (int i = 0; i <= n / denomination; i++) {
            Long amountRemaining = n - i * denomination;
            ways += getWays(amountRemaining, denoms, index + 1); // works, but not optimal; lets eliminate overlapping subproblems
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Long[] denominations = new Long[m];
        for (int i = 0; i < m; i++) {
            denominations[i] = in.nextLong();
        }
        Arrays.sort(denominations, Collections.reverseOrder());
        long ways = getWays(n, denominations, 0);
        System.out.println(ways);
    }
}
