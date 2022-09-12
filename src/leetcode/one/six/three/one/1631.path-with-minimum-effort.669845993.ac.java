package leetcode.one.six.three.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class Cell {
        int row;
        int col;
        int cost;
        
        Cell(int r, int c, int w) {
            row = r;
            col = c;
            cost = w;
        } 
    }
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] cost = new int[n][m];
        for(int[] c: cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        return bfs(heights, n, m, cost);
    }
    
    private int bfs(int[][] heights, int n, int m, int[][] cost) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        PriorityQueue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        q.offer(new Cell(0, 0, 0));
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            int row = cell.row;
            int col = cell.col;
            int weight = cell.cost;
            if (weight > cost[row][col]) {
                continue;
            }
            if (row == n - 1 && col == m - 1) {
                return weight;
            }
            for (int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                    continue;
                }
                int newCost = Math.max(cost[row][col], Math.abs(heights[row][col] - heights[newRow][newCol]));
                if (newCost < cost[newRow][newCol]) {
                    cost[newRow][newCol] = newCost;
                    q.offer(new Cell(newRow, newCol, newCost));
                }
            }
        }
        return cost[n - 1][m - 1];
    }
}

// TC: number of paths x length of the shortest optimal path
