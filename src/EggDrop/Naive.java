package EggDrop;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Scanner;

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
