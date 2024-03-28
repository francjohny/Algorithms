package CodeforcesRaif.E;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Program {
    static class Carrot implements Comparable<Carrot> {
        int length;
        int parts;

        public Carrot(int length, int parts) {
            this.length = length;
            this.parts = parts;
        }

        private long square(int x) {
            return (long) x * x;
        }

        private long cost() {
            int biggs = length % parts;
            int smalls = parts - biggs;
            int smallerLength = length / parts;
            int biggerLength = length / parts + 1;
            return smalls * square(smallerLength) + biggs * square(biggerLength);
        }

        private long decreaseInCost() {
            long originalCost = cost();
            parts++;
            long newCost = cost();
            parts--;
            return originalCost - newCost;
        }

        @Override
        public int compareTo(Carrot carrot) {
            return Long.compare(carrot.decreaseInCost(), this.decreaseInCost());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        long sum = 0;
        PriorityQueue<Carrot> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            priorityQueue.add(new Carrot(a[i], 1));
        }
        for (int i = 0; i < k - n; i++) {
            Carrot carrot = priorityQueue.remove();
            carrot.parts++;
            priorityQueue.add(carrot);
        }
        while (!priorityQueue.isEmpty()) {
             sum += priorityQueue.remove().cost();
        }
        System.out.println(sum);
    }
}
