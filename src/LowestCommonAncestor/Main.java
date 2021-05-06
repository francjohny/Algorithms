package LowestCommonAncestor;

import java.util.*;
import java.lang.*;

class Main
{
    private static int LOG = 20;
    private static List<Integer>[] children;
    private static int[][] dp;
    private static int[] depth;

    private static void dfs(int node) {
        for (int child: children[node]) {
            dp[child][0] = node;
            depth[child] = depth[node] + 1;
            for (int i = 1; i < LOG; i++) {
                dp[child][i] = dp[dp[child][i - 1]][i - 1];
            }
            dfs(child);
        }
    }

    private static int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int k = depth[a] - depth[b];
        for(int i = LOG - 1; i >= 0; i--) {
            if ((k & (1 << i)) != 0) {
                a = dp[a][i];
            }
        }
        if (a == b) {
            return a;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (dp[a][i] != dp[b][i]) {
                a = dp[a][i];
                b = dp[b][i];
            }
        }
        return dp[a][0];
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        children = new List[n];
        dp = new int[n][LOG];
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            children[i] = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                children[i].add(scanner.nextInt());
            }
        }
        dfs(0);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(getLCA(a, b));
        }
    }
}