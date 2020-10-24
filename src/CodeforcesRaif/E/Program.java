package CodeforcesRaif.E;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Program {
    static class Seg {
        long cost;
        int length;
        int parts;

        public Seg(long cost, int length, int parts) {
            this.cost = cost;
            this.length = length;
            this.parts = parts;
        }
    }

    private static long square(int x) {
        return (long) x * x;
    }

    private static long cost(int length, int parts) {
        parts++;
        int n = length / parts;
        int extra = length % parts;
        return parts * square(n) + extra * (square(n + 1) - square(n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        PriorityQueue<Seg> priorityQueue = new PriorityQueue<>((seg, t1) -> (int) (-seg.cost + t1.cost));
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += cost(a[i], 0);
            priorityQueue.add(new Seg(cost(a[i], 0) - cost(a[i], 1), a[i], 1));
        }
        for (int i = 0; i < k - n; i++) {
            Seg seg = priorityQueue.remove();
            sum -= seg.cost;
            priorityQueue.add(new Seg(cost(seg.length, seg.parts) - cost(seg.length, seg.parts + 1), seg.length, seg.parts + 1));
        }
        System.out.println(sum);
    }
}
