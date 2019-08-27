package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    private int dest;
    private int weight;

    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    int getDest() {
        return dest;
    }

    int getWeight() {
        return weight;
    }
}

public class Naive {
    private static List<Edge>[] edges;
    private static long distances[];

    public static void main(String[] args) {
        FastIO in = new FastIO();
        int t = in.getInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.getInt();
            int m = in.getInt();
            distances = new long[n];
            Arrays.fill(distances, Long.MAX_VALUE);
            edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int a1 = 0; a1 < m; a1++) {
                int x = in.getInt() - 1;
                int y = in.getInt() - 1;
                int r = in.getInt();
                edges[x].add(new Edge(y, r));
                edges[y].add(new Edge(x, r));
            }
            int s = in.getInt() - 1;
            findShortestPathFromSource(s);
        }
    }

    private static void findShortestPathFromSource(int src) {
        int s = src;
        distances[src] = 0;
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparingLong((Integer o) -> distances[o]).thenComparingInt(o -> o));
        set.add(src);
        while (!set.isEmpty()) {
            src = set.pollFirst();
            for (Edge edge : edges[src]) {
                if (distances[edge.getDest()] > distances[src] + edge.getWeight()) {
                    set.remove(edge.getDest());
                    distances[edge.getDest()] = distances[src] + edge.getWeight();
                    set.add(edge.getDest());
                }
            }
        }
        for (int i = 0; i < distances.length; i++) {
            if (i != s)
                if (distances[i] != Long.MAX_VALUE)
                    System.out.print(distances[i] + " ");
                else
                    System.out.print(-1 + " ");
        }
        System.out.println();
    }
}

class FastIO {
    private BufferedReader br;
    private StringTokenizer stringTokenizer;

    FastIO() {
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
}
