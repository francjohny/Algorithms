package AtCoder.Contest199.IPFL;

import java.util.Scanner;

public class Main {
    static void swap(char[] str, int i, int j)
    {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    static String swap(char[] str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str[i + n]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] s = scanner.next().toCharArray();
        int q = scanner.nextInt();
        int flip = 0;
        while (q-- > 0) {
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            switch (t) {
                case 1:
                    if (flip != 0) {
                        if (a <= n) {
                            a += n;
                        } else {
                            a -= n;
                        }
                        if (b <= n) {
                            b += n;
                        } else {
                            b -= n;
                        }
                    }
                    swap(s, a - 1, b - 1);
                    break;
                case 2:
                    flip ^= 1;
                    break;
            }
        }
        if (flip != 0) {
            System.out.println(swap(s, n));
            return;
        }
        System.out.println(s);
    }
}
