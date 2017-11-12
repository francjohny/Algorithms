package CoinChange;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Here we store the checked solutions and use the stored values to avoid repeatedly calculating the same values.
 * Caches used:
 * amountDenom - HashMap<Integer, HashMap<Integer, Long>> - representing amount -> (denomination -> ways)
 * denomWays - HashMap<Integer, Long> - representing denomination -> ways
 */
public class Optimised {

    private static HashMap<Integer, HashMap<Integer, Long>> amountDenom = new HashMap<>(); // amount -> (denomination -> ways)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        int m = in.nextInt();
        Integer coins[] = new Integer[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        long totalWays = getWays(amount, coins, 0);
        System.out.println(totalWays);
    }

    private static long getWays(int amount, Integer coins[], int index) {
        HashMap<Integer, Long> denomWays = amountDenom.get(amount); // denomination -> ways
        if (denomWays != null && denomWays.get(coins[index]) != null)
            return denomWays.get(coins[index]);
        if (index >= coins.length - 1) {
            if (amount % coins[index] == 0) {
                return 1;
            }
            return 0;
        }
        long ways = 0;
        int denomination = coins[index];
        for (int i = 0; i <= amount / denomination; i++) {
            int amountLeft = amount - denomination * i;
            ways += getWays(amountLeft, coins, index + 1);
        }
        if (denomWays == null) {
            denomWays = new HashMap<>();
            amountDenom.put(amount, denomWays);
        }
        denomWays.put(denomination, ways);

        return ways;
    }
}
