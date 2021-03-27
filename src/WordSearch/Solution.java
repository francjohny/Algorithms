package WordSearch;

public class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        if (word.length() > m * n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) != board[i][j]) {
                    continue;
                }
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int pos) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (pos >= word.length() || i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) {
            return false;
        }

        if (pos == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        for (int[] direction : directions) {
            if (dfs(board, word, i + direction[0], j + direction[1], pos + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
