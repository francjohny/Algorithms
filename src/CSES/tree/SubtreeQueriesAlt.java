package CSES.tree;

import java.util.*;
import java.io.*;

class SubtreeQueriesAlt {
    public static int[] st;
    public static int[] en;
    public static int timer, n;
    public static ArrayList<Integer> g[];

    //Segtree code
    public static final int N = (int) 1e5;  // limit for array size
    public static long t[] = new long[2 * N];

    public static void update(int p, long value) {  // set value at position p
        for (t[p += n] = value; p > 1; p >>= 1) t[p >> 1] = t[p] + t[p ^ 1];
    }

    public static long query(int l, int r) {  // sum on interval [l, r) (0-INDEXED)
        long res = 0;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) != 0) res += t[l++];
            if ((r & 1) != 0) res += t[--r];
        }
        return res;
    }

    public static void dfs(int i, int p) {
        st[i] = timer++;
        for (int next : g[i]) {
            if(next != p) dfs(next, i);
        }
        en[i] = timer-1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        int q = Integer.parseInt(str.nextToken());
        int[] val = new int[n + 1];
        g = new ArrayList[n + 1];
        str = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
            val[i] = Integer.parseInt(str.nextToken());
        }
        st = new int[n + 1];
        en = new int[n + 1];
        timer = 0;
        for (int i = 0; i < n - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1, 0);
        for (int i = 1; i <= n; i++) {
            update(st[i], val[i]);
        }
        for (int i = 0; i < q; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(str.nextToken());
                int c = Integer.parseInt(str.nextToken());
                update(st[b], c);
            } else {
                int b = Integer.parseInt(str.nextToken());
                System.out.println(query(st[b], en[b] + 1));
            }
        }
    }
}