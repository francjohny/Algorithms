package AtCoder.Visibility197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char[][] chars = new char[h][w];
        for (int i = 0; i < h; i++) {
            chars[i] = scanner.next().toCharArray();
        }
        int result = 0;
        // up
        for (int i = x - 2; i >= 0; i--) {
            if (chars[i][y - 1] == '.') {
                result++;
            } else if (chars[i][y - 1] == '#') {
                break;
            }
        }
        // down
        for (int i = x; i < h; i++) {
            if (chars[i][y - 1] == '.') {
                result++;
            } else if (chars[i][y - 1] == '#') {
                break;
            }
        }
        // left
        for (int i = y - 2; i >= 0; i--) {
            if (chars[x - 1][i] == '.') {
                result++;
            } else if (chars[x - 1][i] == '#') {
                break;
            }
        }
        // right
        for (int i = y; i < w; i++) {
            if (chars[x - 1][i] == '.') {
                result++;
            } else if (chars[x - 1][i] == '#') {
                break;
            }
        }
        System.out.println(result + 1);
    }
}
