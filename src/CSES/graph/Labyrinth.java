package CSES.graph;

import java.util.*;

public class Labyrinth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'B') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        final int[] dirs = new int[]{0, 1, 0, -1, 0}; // R D L U
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        int distance = 0;
        boolean hasReached = false;
        char[][] previousDirection = new char[n][m];
        final char[] signals = new char[]{'R', 'D', 'L', 'U'};
        Map<Character, int[]> map = new HashMap<>();
        map.put('R', new int[]{0, 1});
        map.put('D', new int[]{1, 0});
        map.put('L', new int[]{0, -1});
        map.put('U', new int[]{-1, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] elems = queue.poll();
                int x = elems[0], y = elems[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dirs[i], newY = y + dirs[i + 1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] == '#' || visited[newX][newY]) {
                        continue;
                    }
                    previousDirection[newX][newY] = signals[i];
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                    if (grid[newX][newY] == 'B') {
                        hasReached = true;
                        break;
                    }
                }
            }
            distance++;
            if (hasReached) break;
        }
        StringBuilder sb = new StringBuilder();
        if (hasReached) {
            System.out.println("YES");
            System.out.println(distance);
            while (end[0] != start[0] || end[1] != start[1]) {
                sb.append(previousDirection[end[0]][end[1]]);
                int dx = map.get(previousDirection[end[0]][end[1]])[0];
                int dy = map.get(previousDirection[end[0]][end[1]])[1];
                end[0] -= dx;
                end[1] -= dy;
            }
            System.out.println(sb.reverse());
        } else {
            System.out.println("NO");
        }
    }
}
