package Codeforces675.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][m];
            long sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            boolean[][] visited = new boolean[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (visited[x][y]) continue;
                    List<Integer> list = new ArrayList<>();
                    int ox = n - x - 1;
                    int oy = m - y - 1;
                    int[] xs = {x, x, ox, ox}, ys = {y, oy, y, oy};
                    for (int j = 0; j < 4; j++) {
                        int dx = xs[j], dy = ys[j];
                        if (!visited[dx][dy]) {
                            list.add(arr[dx][dy]);
                            visited[dx][dy] = true;
                        }
                    }
                    Collections.sort(list);
                    int diff = list.get(list.size() / 2);
                    for (Integer item :
                            list) {
                        sum += Math.abs(item - diff);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
