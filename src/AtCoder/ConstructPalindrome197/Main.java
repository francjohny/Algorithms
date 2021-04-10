package AtCoder.ConstructPalindrome197;

import java.util.*;

class Edge {
    int to, character;

    public Edge(int to, int character) {
        this.to = to;
        this.character = character;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static final int INF = (int) (1e9 + 5);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            char c = scanner.next().charAt(0);
            (graph[a] == null ? graph[a] = new ArrayList<>() : graph[a]).add(new Edge(b, c - 'a'));
            (graph[b] == null ? graph[b] = new ArrayList<>() : graph[b]).add(new Edge(a, c - 'a'));
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        Queue<Pair> queue = new ArrayDeque<>();
        push(dp, queue, 0, n - 1, 0);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int low = pair.x;
            int high = pair.y;
            for (Edge ea:
                 graph[low]) {
                for (Edge eb:
                     graph[high]) {
                    if (ea.character != eb.character) continue;
                    push(dp, queue, ea.to, eb.to, dp[low][high] + 1);
                }
            }
        }
        int ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i][i] * 2);
            for (Edge e :
                    graph[i]) {
                ans = Math.min(ans, dp[i][e.to] * 2 + 1);
            }
        }
        System.out.println(ans == INF ? -1 : ans);
    }

    private static void push(int[][] dp, Queue<Pair> queue, int a, int b, int x) {
        if (dp[a][b] != INF) {
            return;
        }
        dp[a][b] = x;
        queue.add(new Pair(a, b));
    }
}
