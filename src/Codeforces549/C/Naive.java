package Codeforces549.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Naive {

    static class FastIO {
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

    private static class Node {
        int id;
        Node parent;
        List<Node> children = new ArrayList<>();
        int childrenCount;
        boolean c;
        boolean deleted;
    }

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        int n = fastIO.getInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
        }
        Node root = null;
        for (int i = 1; i <= n; i++) {
            int p = fastIO.getInt();
            int c = fastIO.getInt();
            if (p == -1) {
                root = nodes[i];
            } else {
                nodes[i].parent = nodes[p];
                nodes[p].children.add(nodes[i]);
            }
            nodes[i].c = c == 1;
        }
        List<Node> deleted = new ArrayList<>();
        dfs(root, deleted);
        if (deleted.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Collections.sort(deleted, Comparator.comparingInt(a -> a.id));
        StringBuilder sb = new StringBuilder();
        for (Node node: deleted)  {
            sb.append(node.id).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(Node root, List<Node> deleted) {
        boolean isDeleted = root.c && root.parent != null;
        for(Node child: root.children) {
            dfs(child, deleted);
            isDeleted = isDeleted && child.c;
        }
        if (isDeleted) {
            root.deleted = isDeleted;
            deleted.add(root);
        }
    }
}
