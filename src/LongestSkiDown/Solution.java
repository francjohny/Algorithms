package LongestSkiDown;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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
class Pair<K,V> implements Serializable {
    public K key;

    public K getKey() { return key; }

    public V value;

    public V getValue() { return value; }

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (!Objects.equals(key, pair.key)) return false;
            return Objects.equals(value, pair.value);
        }
        return false;
    }
}

public class Solution {
    private static int M;
    private static int N;
    private static int elevation[][];
    private static List<Integer>[][] paths;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        paths = new ArrayList[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                paths[i][j] = new ArrayList<>();

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
                final List<Integer> longestPath = longestPath(i, j);
                final int skiDown = longestPath.size();
                final int drop = longestPath.get(longestPath.size() - 1) - longestPath.get(0);
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
        final List<Integer> longestPath = paths[x][y];
        for (int i = longestPath.size() - 1; i >= 1; i--) {
            System.out.print(longestPath.get(i) + "-");
        }
        System.out.println(longestPath.get(0));
        System.out.println("steepest drop = " + steepestDrop);
    }

    /**
     * longestPath() computes the length of the longest ski down from each point
     * by recursively computing the length of the longest ski down from each neighboring point.
     * It does this with the help of checkLongestPath() which checks if the elevation of the area you are going into is less than the one you are in.
     *
     * @param i the x coordinate of the matrix
     * @param j the y coordinate of the matrix
     * @return length of the longest ski down from (i,j)
     */
    private static List<Integer> longestPath(int i, int j) {
        if (paths[i][j].size() != 0) {
            return new ArrayList<>(paths[i][j]);
        }

        List<Integer> l1 = checkLongestPath(i, j, right(i, j));
        List<Integer> l2 = checkLongestPath(i, j, down(i, j));
        List<Integer> l3 = checkLongestPath(i, j, left(i, j));
        List<Integer> l4 = checkLongestPath(i, j, up(i, j));
        List<Integer> longestSkiDown = l1;
        int drop1 = l1.get(l1.size() - 1) - l1.get(0);
        int drop2 = l2.get(l2.size() - 1) - l2.get(0);
        int drop3 = l3.get(l3.size() - 1) - l3.get(0);
        int drop4 = l4.get(l4.size() - 1) - l4.get(0);
        int steepestDrop = drop1;
        if (l2.size() > longestSkiDown.size() || (l2.size() == longestSkiDown.size() && drop2 > steepestDrop)) {
            longestSkiDown = l2;
            steepestDrop = drop2;
        }
        if (l3.size() > longestSkiDown.size() || (l3.size() == longestSkiDown.size() && drop3 > steepestDrop)) {
            longestSkiDown = l3;
            steepestDrop = drop3;
        }
        if (l4.size() > longestSkiDown.size() || (l4.size() == longestSkiDown.size() && drop4 > steepestDrop)) {
            longestSkiDown = l4;
            steepestDrop = drop4;
        }

        paths[i][j].addAll(longestSkiDown);

        return longestSkiDown;
    }

    private static List<Integer> checkLongestPath(int i, int j, Pair<Integer, Integer> pos) {
        Integer k = pos.getKey();
        Integer v = pos.getValue();
        List<Integer> longestSeq = new ArrayList<>();
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
