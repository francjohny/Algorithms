package CodeforcesRaif.E;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Program {
    static class Carrot {
        long splitCost;
        int length;
        int parts;

        public Carrot(long splitCost, int length, int parts) {
            this.splitCost = splitCost;
            this.length = length;
            this.parts = parts;
        }
    }

    private static long square(int x) {
        return (long) x * x;
    }

    private static long cost(int length, int parts) {
        int units = length / parts;
        int extra = length - units * parts;
        return (parts - extra) * square(units) + extra * square(units + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        long sum = 0;
        PriorityQueue<Carrot> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.splitCost < o2.splitCost) {
                return 1;
            }
            if (o1.splitCost == o2.splitCost) {
                if (o1.length < o2.length) {
                    return 1;
                }
                if (o1.length == o2.length) {
                    return Integer.compare(o2.parts, o1.parts);
                }
                return -1;
            }
            return -1;
        });
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += square(a[i]);
            priorityQueue.add(new Carrot(cost(a[i], 1) - cost(a[i], 2), a[i], 2));
        }
        for (int i = 0; i < k - n; i++) {
            Carrot carrot = priorityQueue.remove();
            sum -= carrot.splitCost;
            priorityQueue.add(new Carrot(cost(carrot.length, carrot.parts) - cost(carrot.length, carrot.parts + 1), carrot.length, carrot.parts + 1));
        }
        System.out.println(sum);
    }
}
