package DavisStaircase;

import java.util.Scanner;

/*
 * Davis has s staircases in his house and he likes to climb each staircase 1, 2, or 3 steps at a time.
 * Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
 * Given the respective heights for each of the s staircases in his house, find and print the number of ways he can climb each staircase.
 *
 * Input:
 * 3
 * 1
 * 3
 * 7
 *
 * Output:
 * 1
 * 4
 * 44
 */
public class Naive {

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
        if (height == 0)
            return 1;
        if (height < 0)
            return 0;
        return computeWays(height - 1) + computeWays(height - 2) + computeWays(height - 3);
    }
}
