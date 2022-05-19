package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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

public class MessageRoute {
    public static void main(String[] args) throws IOException {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        ++n;
        int m = fastIO.getInt();
        m++;
        List<Integer>[] graph = new List[n];
        for (int i = 1; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < m; i++) {
            int node1 = fastIO.getInt();
            int node2 = fastIO.getInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n];
        visited[1] = true;
        boolean flag = false;
        int minComputers = 0;
        int[] previousNode = new int[n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                for (Integer u : graph[v]) {
                    if (visited[u]) {
                        continue;
                    }

                    visited[u] = true;
                    previousNode[u] = v;
                    queue.offer(u);
                    if (u == (n - 1)) {
                        flag = true;
                        break;
                    }
                }
            }
            minComputers++;
            if (flag) {
                break;
            }
        }
        List<Integer> nodes = new ArrayList<>();
        if (flag) {
            System.out.println(minComputers + 1);
            int iter = n - 1;
            nodes.add(n - 1);
            while (iter != 1) {
                nodes.add(previousNode[iter]);
                iter = previousNode[iter];
            }
            for (int i = nodes.size() - 1; i >= 0; i--) {
                System.out.print(nodes.get(i) + " ");
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
