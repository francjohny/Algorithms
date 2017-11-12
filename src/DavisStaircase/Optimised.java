package DavisStaircase;

import java.util.HashMap;
import java.util.Scanner;

public class Optimised {
    private static HashMap<Integer, Integer> heightWaysMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int height = in.nextInt();
            int ways = computeWays(height);
            System.out.println(ways);
        }
    }

    private static int computeWays(int height) {
        if (heightWaysMap.containsKey(height)) {
            return heightWaysMap.get(height);
        }
        if (height == 0)
            return 1;
        if (height < 0)
            return 0;
        Integer ways = computeWays(height - 1) + computeWays(height - 2) + computeWays(height - 3);
        heightWaysMap.put(height, ways);
        return ways;
    }
}
