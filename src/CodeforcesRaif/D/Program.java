package CodeforcesRaif.D;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        Deque<Integer> ones = new ArrayDeque<>(n);
        Deque<Integer> oneYs = new ArrayDeque<>(n);
        Deque<Integer> others = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        int y = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 1) {
                ones.add(i);
                oneYs.add(y);
                xs.add(i);
                ys.add(y--);
            } else if (a[i] == 2) {
                if (ones.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                ones.remove();
                int oneY = oneYs.remove();
                xs.add(i);
                ys.add(oneY);
                others.add(i);
                y--;
            } else if (a[i] == 3) {
                if (!others.isEmpty()) {
                    int other = others.remove();
                    xs.add(i);
                    ys.add(y);
                    xs.add(other);
                    ys.add(y);
                } else if (!ones.isEmpty()) {
                    int one = ones.remove();
                    oneYs.remove();
                    xs.add(i);
                    ys.add(y);
                    xs.add(one);
                    ys.add(y);
                } else {
                    System.out.println(-1);
                    return;
                }
                others.add(i);
                y--;
            }
        }
        System.out.println(xs.size());
        for (int i = 0; i < xs.size(); i++) {
            System.out.println((ys.get(i) + 1) + " " + (xs.get(i) + 1));
        }
    }
}
