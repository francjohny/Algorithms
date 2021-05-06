package AtCoder.DP.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] edges;
    private static int[] indegree;
    private static boolean[] visited;
    private static int[] distance;
    private static final int MAX = (int) (1e5 + 4);

    private static void dfs(int node) {
        visited[node] = true;
        for (int child :
                edges[node]) {
            distance[child] = Math.max(distance[child], distance[node] + 1);
            indegree[child]--;
            if (indegree[child] == 0) {
                dfs(child);
            }
        }
    }

    public static void main(String[] args) {
        FastIO in = new FastIO();
        int n = in.getInt();
        int m = in.getInt();
        edges = new List[MAX];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        indegree = new int[MAX];
        distance = new int[MAX];
        visited = new boolean[MAX];
        for (int i = 0; i < m; i++) {
            int x = in.getInt();
            int y = in.getInt();
            edges[x].add(y);
            indegree[y]++;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && indegree[i] == 0) {
                dfs(i);
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, distance[i]);
        }
        System.out.println(answer);
    }
}

class FastIO {
    private BufferedReader br;
    private StringTokenizer stringTokenizer;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        try {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringTokenizer.nextToken();
    }

    public int getInt() {
        return Integer.parseInt(next());
    }

    public long getLong() {
        return Long.parseLong(next());
    }

    public double getDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
