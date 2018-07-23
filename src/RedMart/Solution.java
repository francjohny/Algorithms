package RedMart;

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
    private static int len[][];
    private static int lowestElevation;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();

        // elevation of each area of the mountain
        elevation = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                elevation[i][j] = in.nextInt();
            }
        }

        // length of the longest ski-down from each area, initially `Integer.MIN_VALUE`
        len = new int[M][N];
        for (int[] row : len) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        // step 1. compute the length of the longest ski-down from each area
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                longestPathLength(i, j);
            }
        }
        final int longestSkiDown = Arrays.stream(len).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);

        // step 2. compute the highest drop from the highest peak
        List<Integer> drops = new ArrayList<>();
        System.out.print("longest paths = ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (len[i][j] == longestSkiDown) {
                    drops.add(elevation[i][j] - lowestPoint(i, j));
                    System.out.print("...");
                }
            }
        }
        final Integer steepestDrop = Collections.max(drops);

        // output
        System.out.printf("\nsteepest drop = %d ft%n", steepestDrop);
        System.out.printf("longest ski down = %d blocks%n", longestSkiDown + 1);
        // TODO: print the longest steepest path
    }

    /**
     * lowestPoint() gets the lowest elevation of a given point in the map
     * by recursively computing the lowest point from each adjacent area.
     * It does this with the help of checkLowestPoint() which checks if the drop from the elevation of the area you are going into is minimal than the one you are in.
     *
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return lowest elevation from (i,j)
     */
    private static int lowestPoint(int i, int j) {
        System.out.print("[" + elevation[i][j] + ", " + len[i][j] + "]");
        if (len[i][j] == 0) {
            return lowestElevation;
        }

        int l1 = checkLowestPoint(i, j, right(i, j));
        int l2 = checkLowestPoint(i, j, down(i, j));
        int l3 = checkLowestPoint(i, j, left(i, j));
        int l4 = checkLowestPoint(i, j, up(i, j));

        lowestElevation = Integer.min(Integer.min(l1, l2), Integer.min(l3, l4));
        return lowestElevation;
    }

    private static int checkLowestPoint(int i, int j, Pair<Integer, Integer> pos) {
        int min = Integer.MAX_VALUE;
        Integer k = pos.getKey();
        Integer v = pos.getValue();
        if (exists(pos) && len[k][v] == (len[i][j] - 1)) {
            lowestElevation = elevation[k][v];
            min = lowestPoint(k, v);
        }
        return min;
    }

    /**
     * longestPathLength() computes the length of the longest ski down from each area
     * by recursively computing the length of the longest ski down from each adjacent area.
     * It does this with the help of checkLongestPath() which checks if the elevation of the area you are going into is less than the one you are in.
     *
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return length of the longest ski down from (i,j)
     */
    private static int longestPathLength(int i, int j) {
        if (len[i][j] != Integer.MIN_VALUE) {
            return len[i][j];
        }

        int l1 = checkLongestPath(i, j, right(i, j));
        int l2 = checkLongestPath(i, j, down(i, j));
        int l3 = checkLongestPath(i, j, left(i, j));
        int l4 = checkLongestPath(i, j, up(i, j));

        len[i][j] = Integer.max(Integer.max(l1, l2), Integer.max(l3, l4));
        return len[i][j];
    }

    private static int checkLongestPath(int i, int j, Pair<Integer, Integer> pos) {
        int length = 0;
        Integer k = pos.getKey();
        Integer v = pos.getValue();
        if (exists(pos) && elevation[i][j] > elevation[k][v]) {
            length += longestPathLength(k, v) + 1;
        }
        return length;
    }
    
    ///////////////////// HELPER FUNCTIONS /////////////////////

    /**
     * checks if (i,j) is in the boundary of the matrix
     *
     * @param pos position of element in matrix
     * @return true if position is in inside matrix, false otherwise
     */
    private static boolean exists(Pair<Integer, Integer> pos) {
        Integer i = pos.getKey();
        Integer j = pos.getValue();
        return i >= 0 && i < M && j >= 0 && j < N;
    }

    /**
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return the coordinates of the matrix down of (i,j)
     */
    private static Pair<Integer, Integer> down(int i, int j) {
        return new Pair<>(i + 1, j);
    }

    /**
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return the coordinates of the matrix right of (i,j)
     */
    private static Pair<Integer, Integer> right(int i, int j) {
        return new Pair<>(i, j + 1);
    }

    /**
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return the coordinates of the matrix up of (i,j)
     */
    private static Pair<Integer, Integer> up(int i, int j) {
        return new Pair<>(i - 1, j);
    }

    /**
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return the coordinates of the matrix left of (i,j)
     */
    private static Pair<Integer, Integer> left(int i, int j) {
        return new Pair<>(i, j - 1);
    }
}
