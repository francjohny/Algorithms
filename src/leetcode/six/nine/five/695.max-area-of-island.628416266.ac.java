package leetcode.six.nine.five;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int ans = dfs(grid, n, m, i, j, visited, 0);
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int n, int m, int i, int j, boolean[][] visited, int count) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        count++;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int[] direction: directions) {
            count += dfs(grid, n, m, i + direction[0], j + direction[1], visited, 0);
        }
        return count;
    }
}
