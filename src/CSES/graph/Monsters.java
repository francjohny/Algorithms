package CSES.graph;

import java.util.*;

public class Monsters {
    private static final int[] dirs = new int[]{0, 1, 0, -1, 0}; // R D L U
    private static int n, m;
    private static int[] end = new int[2];
    private static char[][] previousDirection;

    private static void monsterBFS(List<int[]> monsters, int[][] dist) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] monster :
                monsters) {
            queue.offer(monster);
        }
        while (!queue.isEmpty()) {
            int[] elem = queue.poll();
            int timer = elem[2];
            timer++;
            for (int i = 0; i < 4; i++) {
                int newX = elem[0] + dirs[i], newY = elem[1] + dirs[i + 1];
                if (isValid(newX, newY, timer, dist)) {
                    dist[newX][newY] = timer;
                    queue.offer(new int[]{newX, newY, timer});
                }
            }
        }
    }

    private static boolean startNodeBFS(int[] start, int[][] dist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], start[2]});
        previousDirection = new char[n][m];
        final char[] signals = new char[]{'R', 'D', 'L', 'U'};
        while (!queue.isEmpty()) {
            int[] elem = queue.poll();
            int timer = elem[2];
            timer++;
            for (int i = 0; i < 4; i++) {
                int newX = elem[0] + dirs[i], newY = elem[1] + dirs[i + 1];
                if (isValid(newX, newY, timer, dist)) {
                    previousDirection[newX][newY] = signals[i];
                    if (newX == 0 || newY == 0 || newX == n - 1 || newY == m - 1) {
                        end = new int[]{newX, newY};
                        return true;
                    }
                    dist[newX][newY] = timer;
                    queue.offer(new int[]{newX, newY, timer});
                }
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int timer, int[][] dist) {
        return x >= 0 && y >= 0 && x < n && y < m && dist[x][y] > timer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        int[] start = new int[3];
        List<int[]> monsters = new ArrayList<>();
        int[][] dist = new int[n][m];
        Arrays.stream(dist).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    dist[i][j] = 0;
                    start = new int[]{i, j, 0};
                } else if (grid[i][j] == 'M') {
                    dist[i][j] = 0;
                    monsters.add(new int[]{i, j, 0});
                } else if (grid[i][j] == '#') {
                    dist[i][j] = 0;
                }
            }
        }
        if (start[0] == 0 || start[1] == 0 || start[0] == n - 1 || start[1] == m - 1) {
            System.out.println("YES \n 0");
            return;
        }
        monsterBFS(monsters, dist);
        boolean possible = startNodeBFS(start, dist);

        Map<Character, int[]> map = new HashMap<>();
        map.put('R', new int[]{0, 1});
        map.put('D', new int[]{1, 0});
        map.put('L', new int[]{0, -1});
        map.put('U', new int[]{-1, 0});
        StringBuilder sb = new StringBuilder();
        if (possible) {
            System.out.println("YES");
            while (end[0] != start[0] || end[1] != start[1]) {
                sb.append(previousDirection[end[0]][end[1]]);
                int dx = map.get(previousDirection[end[0]][end[1]])[0];
                int dy = map.get(previousDirection[end[0]][end[1]])[1];
                end[0] -= dx;
                end[1] -= dy;
            }
            System.out.println(sb.length());
            System.out.println(sb.reverse());
        } else {
            System.out.println("NO");
        }
    }
}