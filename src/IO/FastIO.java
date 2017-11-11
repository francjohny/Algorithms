package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastIO {
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
