package LongestSkiDown;

import javafx.util.Pair;

import java.util.*;

/*
 * Given a map/matrix of size MxN, where each number represents the elevation of an area of a mountain. Find the longest ski run down.
 * From each area (i.e. box) in the grid you can go north, south, east, west -
 * but only if the elevation of the area you are going into is less than the one you are in. I.e. you can only ski downhill.
 * You can start anywhere on the map and you are looking for a starting point with the longest possible path down
 * as measured by the number of boxes you visit. And if there are several paths down of the same length,
 * you want to take the one with the steepest vertical drop,
 * i.e. the largest difference between your starting elevation and your ending elevation.
 *
 * Example:
 * On this particular map below, the longest path down is of length=5 and it’s 9-5-3-2-1.
 *
 * Input:
 * 4 4
 * 4 8 7 3
 * 2 5 9 3
 * 6 3 2 5
 * 4 4 1 6
 *
 * There is another path that is also length five: 8-5-3-2-1. However the tie is broken by the first path being steeper,
 * dropping from 9 to 1, a drop of 8, rather than just 8 to 1, a drop of 7.

 * Output:
 * <length of the longest path><size of the drop> i.e. 58
 */
public class Solution {
    private static int M;
    private static int N;
    private static int elevation[][];
    private static ArrayList[][] paths;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        paths = new ArrayList[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                paths[i][j] = new ArrayList();

            }
        }

        // elevation of each area of the mountain
        elevation = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                elevation[i][j] = in.nextInt();
            }
        }

        int longestSkiDown = Integer.MIN_VALUE;
        int steepestDrop = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                final ArrayList longestPath = longestPath(i, j);
                final int skiDown = longestPath.size();
                final int drop = (int) longestPath.get(longestPath.size() - 1) - (int) longestPath.get(0);
                if (skiDown > longestSkiDown || (skiDown == longestSkiDown && drop > steepestDrop)) {
                    longestSkiDown = skiDown;
                    steepestDrop = drop;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.printf("longest ski down = %d blocks%n", longestSkiDown);
        System.out.print("longest path = ");
        final ArrayList longestPath = paths[x][y];
        for (int i = longestPath.size() - 1; i >= 1; i--) {
            System.out.print(longestPath.get(i) + "-");
        }
        System.out.println(longestPath.get(0));
        System.out.println("steepest drop = " + steepestDrop);
    }

    /**
     * longestPath() computes the length of the longest ski down from each area
     * by recursively computing the length of the longest ski down from each adjacent area.
     * It does this with the help of checkLongestPath() which checks if the elevation of the area you are going into is less than the one you are in.
     *
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return length of the longest ski down from (i,j)
     */
    private static ArrayList longestPath(int i, int j) {
        if (paths[i][j].size() != 0) {
            ArrayList max = new ArrayList();
            for (Object points: paths[i][j]) {
                max.add(points);
            }
            return max;
        }

        ArrayList l1 = checkLongestPath(i, j, right(i, j));
        ArrayList l2 = checkLongestPath(i, j, down(i, j));
        ArrayList l3 = checkLongestPath(i, j, left(i, j));
        ArrayList l4 = checkLongestPath(i, j, up(i, j));
        int drop1 = (int) l1.get(l1.size() - 1) - (int) l1.get(0);
        int drop2 = (int) l2.get(l2.size() - 1) - (int) l2.get(0);
        int drop3 = (int) l3.get(l3.size() - 1) - (int) l3.get(0);
        int drop4 = (int) l4.get(l4.size() - 1) - (int) l4.get(0);
        ArrayList max = l1;
        int steepestDrop = drop1;
        if (l2.size() > max.size() || (l2.size() == max.size() && drop2 > steepestDrop))
            max = l2;
        if (l3.size() > max.size() || (l3.size() == max.size() && drop3 > steepestDrop))
            max = l3;
        if (l4.size() > max.size() || (l4.size() == max.size() && drop4 > steepestDrop))
            max = l4;

        for (Object x : max) {
            paths[i][j].add(x);
        }

        return max;
    }

    private static ArrayList checkLongestPath(int i, int j, Pair<Integer, Integer> pos) {
        Integer k = pos.getKey();
        Integer v = pos.getValue();
        ArrayList longestSeq = new ArrayList<>();
        if (exists(pos) && elevation[i][j] > elevation[k][v]) {
            longestSeq = longestPath(k, v);
        }
        longestSeq.add(elevation[i][j]);
        return longestSeq;
    }
    
    ///////////////////// HELPER FUNCTIONS /////////////////////

    private static boolean exists(Pair<Integer, Integer> pos) {
        Integer i = pos.getKey();
        Integer j = pos.getValue();
        return i >= 0 && i < M && j >= 0 && j < N;
    }

    private static Pair<Integer, Integer> down(int i, int j) {
        return new Pair<>(i + 1, j);
    }

    private static Pair<Integer, Integer> right(int i, int j) {
        return new Pair<>(i, j + 1);
    }

    private static Pair<Integer, Integer> up(int i, int j) {
        return new Pair<>(i - 1, j);
    }
    
    private static Pair<Integer, Integer> left(int i, int j) {
        return new Pair<>(i, j - 1);
    }
}
