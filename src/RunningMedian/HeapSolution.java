package RunningMedian;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> lowers = new PriorityQueue<>(n, (o1, o2) -> -1 * (o1 - o2));
        PriorityQueue<Integer> highers = new PriorityQueue<>(n);
        while (n-- > 0) {
            int key = in.nextInt();
            insert(key, lowers, highers);
            rebalance(lowers, highers);
            double median = computeMedian(lowers, highers);
            System.out.println(median);
        }

    }

    private static double computeMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() == smallerHeap.size()) {
            return (smallerHeap.peek() + biggerHeap.peek()) / 2.0;
        } else {
            return biggerHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void insert(int key, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.isEmpty() || key < lowers.peek())
            lowers.add(key);
        else
            highers.add(key);
    }
}
