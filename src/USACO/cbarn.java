package USACO;

import java.io.*;

public class cbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/USACO/cbarn.in"));
        PrintWriter out = new PrintWriter(new FileWriter("src/USACO/cbarn.out"));
        int n = Integer.parseInt(br.readLine());
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = Integer.parseInt(br.readLine());
        }
        int ans = Integer.MAX_VALUE, sum;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += r[(j + i) % n] * j;
            }
            ans = Math.min(ans, sum);
        }
        out.println(ans);
        out.flush();
    }
}
