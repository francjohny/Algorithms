package ImmutableQueue;

import java.util.Scanner;

/*
 * Immutable Queue implementation using 2 stacks
 *
 * Input consists of q queries, where each query is one of the following 3 types:
 * 1 x: Enqueue element x into the end of the queue.
 * 2: Dequeue element at the front of the queue.
 * 3: Print the element at the front of the queue (null if queue is empty).
 *
 * Example 1:
 *
 * Input:
 * 8
 * 1 5
 * 1 10
 * 1 15
 * 1 20
 * 2
 * 2
 * 2
 * 3
 *
 * Output:
 * 20
 *
 * Input:
 * 5
 * 1 a
 * 1 b
 * 2
 * 1 c
 * 3
 *
 * Output:
 * b
 */
public class Test {
    @SuppressWarnings("unchecked")
    public static <T> void main(String[] args) {
        Queue<T> jobQueue = new ImmutableQueue<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                jobQueue = jobQueue.enQueue((T) scan.next());
            } else if (operation == 2) { // dequeue
                jobQueue = jobQueue.deQueue();
            } else if (operation == 3) { // print/peek
                System.out.println(jobQueue.head());
            }
        }
        scan.close();
    }
}
