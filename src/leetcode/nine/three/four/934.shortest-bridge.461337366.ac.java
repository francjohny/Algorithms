package leetcode.nine.three.four;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    Deque<int[]> queue;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        visited = new boolean[m][n];
        queue = new ArrayDeque<>();
        boolean found1 = false;
        for (int i = 0; i < m; i++) {
            if (found1) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    found1 = true;
                    break;
                }
            }
        }
        int steps = 0;
        while(!queue.isEmpty()) {            
            for (int size = queue.size(); size > 0; size--) {
                int[] cur = queue.poll();
                 for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if (checkBoundary(i, j, A, visited)) {
                        continue;
                    }
                    if (A[i][j] == 1) {
                        return steps;
                    }
                     queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }                
            }
            steps++;
        }
        return -1;
    }
    
    private boolean checkBoundary(int i, int j, int[][] A, boolean[][] visited) {
        return i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j];
    }
    
    private void dfs(int[][] A, int i, int j) {      
        if (checkBoundary(i, j, A, visited) || A[i][j] == 0) {
            return;
        }
        queue.offer(new int[]{i, j});
       visited[i][j] = true;
        for (int[] dir : dirs) {
            dfs(A, i + dir[0], j + dir[1]);
        }        
    }
}
