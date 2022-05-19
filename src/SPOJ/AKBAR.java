package SPOJ;

import java.util.*;
// TODO
public class AKBAR {
    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer>[] graph;
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            n++;
            graph = new List[n];
            int m = scanner.nextInt();
            int r = scanner.nextInt();
            for (int i = 1; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            while (m-- > 0) {
                int u = scanner.nextInt(), v = scanner.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            boolean[] visited = new boolean[n];
            int count = 0;
            while (r-- > 0) {
                queue.offer(new int[]{scanner.nextInt(), scanner.nextInt()});
                while (!queue.isEmpty()) {
                    int[] elems = queue.poll();
                    int city = elems[0], strength = elems[1];
                    if (visited[city]) {
                        continue;
                    }
                    visited[city] = true;
                    count++;
                    if (strength > 0) {
                        for (int adjCity : graph[city]) {
                            queue.offer(new int[]{adjCity, strength - 1});
                        }
                    }
                }
            }
            boolean flag = false;
            for (int i = 1; i < n; i++) {
                boolean b = visited[i];
                if (!b) {
                    flag = true;
                    break;
                }
            }
            System.out.println(count > n || flag ? "NO" : "YES");
        }
    }
}
