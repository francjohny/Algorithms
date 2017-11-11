package CoinChange;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Naive {

    /*Find the number of ways of making change of 100
    * makeChange(100) = makeChange(100 using 0 quarters) + makeChange(100 using 1 quarters) + makeChange(100 using 2 quarters) + makeChange(100 using 3 quarters) + makeChange(100 using 4 quarters)
    * makeChange(100) = makeChange(100 using 0 quarters) + makeChange(75 using 0 quarters) + makeChange(50 using 0 quarters) + makeChange(25 using 0 quarters) + 1
    * makeChange(100 using 0 quarters) = makeChange(100 using 0 quarters, 0 dimes) + makeChange(100 using 0 quarters, 1 dimes) + ... + makeChange(100 using 0 quarters, 10 dimes)
    * makeChange(75 using 0 quarters) = makeChange(75 using 0 quarters, 0 dimes) + makeChange(75 using 0 quarters, 1 dimes) + ... + makeChange(75 using 0 quarters, 7 dimes)
    * makeChange(50 using 0 quarters) = makeChange(50 using 0 quarters, 0 dimes) + makeChange(50 using 0 quarters, 1 dimes) + ... + makeChange(50 using 0 quarters, 5 dimes)
    * makeChange(25 using 0 quarters) = makeChange(25 using 0 quarters, 0 dimes) + makeChange(25 using 0 quarters, 1 dimes) + makeChange(25 using 0 quarters, 2 dimes)
    * */
    static long getWays(long n, Long[] denoms, int index){
        if (index >= denoms.length - 1) {
            if (n % denoms[index] == 0)
                return 1;
            return 0;
        }
        Long denomAmount = denoms[index];
        long ways = 0;
        for (int i = 0; i <= n / denomAmount; i++) {
            Long amountRemaining = n - i * denomAmount;
            ways += getWays(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Long[] denoms = new Long[m];
        for(int c_i=0; c_i < m; c_i++){
            denoms[c_i] = in.nextLong();
        }
        Arrays.sort(denoms, Collections.reverseOrder());
        long ways = getWays(n, denoms, 0);
        System.out.println(ways);
    }
}
