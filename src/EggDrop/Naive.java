package EggDrop;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Classic case of the more generalised problem:
 * There is a building of 100 floors. If an egg drops from the Nth floor or above, it will break.
 * If its's dropped from any floor below, it will not break.
 * You're given two eggs. Find N, while minimising the number of drops for the worst case.
 * Generalising, the problem involves N floors with E eggs,
 * find the minimum floor at which the eggs will start breaking while minimising the number of drops.

 * Assumptions:
 * 1. An egg that survives a fall can be used again.
 * 2. A broken egg must be discarded.
 * 3. The effect of a fall is the same for all eggs.
 * 4. If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * 5. If an egg survives a fall then it would survive a shorter fall.
 * 6. It is not ruled out that the 1st-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
 */
public class Naive {
    private static HashMap<Pair, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int drops = computeNumberOfDrops(n, e);
        System.out.println(drops);
    }

    private static int computeNumberOfDrops(int n, int e) {
        Pair<Integer, Integer> pair1 = new Pair<>(n, e);
        int min = Integer.MAX_VALUE;
        if (hashMap.get(pair1) != null)
            return hashMap.get(pair1);
        if (n == 1 || n == 0)
            return n;
        if (e == 1)
            return n;
        for (int i = 1; i <= n; i++) {
            int max = Math.max(computeNumberOfDrops(i - 1, e - 1), computeNumberOfDrops(n - i, e));
            if (min > max)
                min = max;
        }
        Pair<Integer, Integer> pair = new Pair<>(n, e);
        int value = min + 1;
        hashMap.put(pair, value);
        return value;
    }
}
