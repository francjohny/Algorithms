import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        final int INF = Integer.MAX_VALUE;
        Queue<int[]> q = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[2]));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        q.add(new int[]{0, 0, 0});
        dp[0][0] = 0;
        while(!q.isEmpty()) {
            int[] s = q.poll();
            if (visited[s[0]][s[1]]) continue;
            visited[s[0]][s[1]] = true;
            for(int[] direction: directions) {
                int newX = s[0] + direction[0];
                int newY = s[1] + direction[1];
                if (newX >= n || newY >= m || newX < 0 || newY < 0) continue;
                int newTime = Math.max(moveTime[newX][newY], dp[s[0]][s[1]]) + (s[0] + s[1]) % 2 + 1;
                if (dp[newX][newY] > newTime) {
                    dp[newX][newY] = newTime;
                    q.offer(new int[]{newX, newY, newTime});
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
