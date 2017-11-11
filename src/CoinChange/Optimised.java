package CoinChange;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Optimised {

    private static HashMap<Long, HashMap<Long, Long>> amountDenomMap = new HashMap<>(); // amount -> denom
    static long getWays(long amount, Long[] denoms, int index){
        if (amountDenomMap.get(amount) != null) {
             if (amountDenomMap.get(amount).get(denoms[index]) != null) {
                return amountDenomMap.get(amount).get(denoms[index]);
             }
        }
        if (index >= denoms.length - 1) {
            if (amount % denoms[index] == 0)
                return 1;
            return 0;
        }
        Long denomAmount = denoms[index];
        Long ways = 0L;
        for (int i = 0; i <= amount / denomAmount; i++) {
            Long amountRemaining = amount - i * denomAmount;
            ways += getWays(amountRemaining, denoms, index + 1);
        }
        HashMap<Long, Long> denomWaysMap = amountDenomMap.get(amount);
        if (denomWaysMap == null) {
            denomWaysMap = new HashMap<>(); // denom -> ways
            amountDenomMap.put(amount, denomWaysMap);
        }
        denomWaysMap.put(denomAmount, ways);
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
        Long ways = getWays(n, denoms, 0);
        System.out.println(ways);
    }
}
