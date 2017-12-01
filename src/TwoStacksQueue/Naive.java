package TwoStacksQueue;

import java.util.Scanner;
import java.util.Stack;

/*
 * In this challenge, you must first implement a queue using two stacks.
 * Then process q queries, where each query is one of the following 3 types:
 * 1 x: Enqueue element  into the end of the queue.
 * 2: Dequeue the element at the front of the queue.
 * 3: Print the element at the front of the queue.
 *
 * Input:
 * 10
 * 1 42
 * 2
 * 1 14
 * 3
 * 1 28
 * 3
 * 1 60
 * 1 78
 * 2
 * 2
 *
 * Output:
 * 14
 * 14
 *
 * Maintain 2 stacks - `stackNewestOnTop` for enqueueing elements and `stackOldestOnTop` for dequeueing elements
 * (1)
 * 1 42 = ENQUEUE 42
 *       |  |             |  |
 *       |  |             |  |
 *       |  |             |  |
 *       |42|             |  |
 *       |__|             |__|
 * stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 42
 *       ---------------------
 * (2)
 * 2 = DEQUEUE (remove front element from queue = oldest element from stack)
 *       |  |             |  |               |  |             |  |
 *       |  |             |  |               |  |             |  |
 *       |  |             |  |        =>     |  |             |  |
 *       |  |             |42|               |  |             |  |
 *       |__|             |__|               |__|             |__|
 * stackNewestOnTop  stackOldestOnTop  stackNewestOnTop  stackOldestOnTop
 *
 * pop the top element from stackOldestOnTop
 * since `stackOldestOnTop` is empty, transfer all elements from `stackNewestOnTop` to get the OldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       |
 *       ---------------------
 *
 * 3)
 * 1 14 = ENQUEUE 14
 *       |  |             |  |
 *       |  |             |  |
 *       |  |             |  |
 *       |14|             |  |
 *       |__|             |__|
 * stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 14
 *       ---------------------
 * 4)
 * 3 = PEAK (at the front of the queue = the first element added to the queue = the oldest element on the stack)
 * since `stackOldestOnTop` is empty, get the first element = oldest element on `stackNewestOnTop` = 14
 *
 * 5)
 * 1 28 = ENQUEUE 28
 *       |  |             |  |
 *       |  |             |  |
 *       |28|             |  |
 *       |14|             |  |
 *       |__|             |__|
 * stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 14 28
 *       ---------------------
 *
 * 6)
 * 3 = PEAK (at the front of the queue = the first element added to the queue = the oldest element on the stack)
 * since `stackOldestOnTop` is empty, get the first element = oldest element on `stackNewestOnTop` = 14
 *
 * 7)
 * 1 60 = ENQUEUE 60
 *       |  |             |  |
 *       |60|             |  |
 *       |28|             |  |
 *       |14|             |  |
 *       |__|             |__|
 * stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 14 28 60
 *       ---------------------
 * 8)
 * 1 78 = ENQUEUE 78
 *       |78|             |  |
 *       |60|             |  |
 *       |28|             |  |
 *       |14|             |  |
 *       |__|             |__|
 * stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 14 28 60 78
 *       ---------------------
 * 9)
 * 2 = DEQUEUE (remove front element from queue = oldest element from stack) = 14
 *       |78|             |  |               |  |             |14|               |  |             |  |
 *       |60|             |  |               |  |             |28|               |  |             |28|
 *       |28|             |  |        =>     |  |             |60|        =>     |  |             |60|
 *       |14|             |  |               |  |             |78|               |  |             |78|
 *       |__|             |__|               |__|             |__|               |__|             |__|
 * stackNewestOnTop  stackOldestOnTop  stackNewestOnTop  stackOldestOnTop  stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 28 60 78
 *       ---------------------
 * 9)
 * 2 = DEQUEUE (remove front element from queue = oldest element from stack)
 *       |  |             |  |               |  |             |  |
 *       |  |             |28|               |  |             |  |
 *       |  |             |60|        =>     |  |             |60|
 *       |  |             |78|               |  |             |78|
 *       |__|             |__|               |__|             |__|
 * stackNewestOnTop  stackOldestOnTop  stackNewestOnTop  stackOldestOnTop  stackNewestOnTop  stackOldestOnTop
 *
 * Equivalent queue:
 *       ---------------------
 *       | 60 78
 *       ---------------------
 */
public class Naive {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<>();
        Stack<T> stackOldestOnTop = new Stack<>();

        void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.add(value);
        }

        T peek() {
            if (!stackOldestOnTop.isEmpty())
                return stackOldestOnTop.peek();
            return stackNewestOnTop.get(0);
        }

        T dequeue() {
            if (!stackOldestOnTop.isEmpty())
                return stackOldestOnTop.pop();
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.add(stackNewestOnTop.pop());
            }
            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
