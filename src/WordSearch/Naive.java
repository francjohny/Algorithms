package WordSearch;

class Naive {
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
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length() - 1) {
            return true;
        }
        int[][] directions = new int[][]{{0, 1}, {0 , -1}, {1, 0}, {-1,0 }};
        for (int[] direction: directions) {
            int dx = direction[0];
            int dy = direction[1];
            if (!(i + dx < 0 || j + dy < 0 || i + dx >= board.length || j + dy >= board[0].length || board[i + dx][j + dy] != word.charAt(pos + 1) || visited[i + dx][j + dy])) {
                visited[i + dx][j + dy] = true;
                if (dfs(board, word, i + dx, j + dy, pos + 1)) {
                    return true;
                }
                visited[i + dx][j + dy] = false;
            }

        }
        return false;
    }
}
