package CycleLinkedList;

/*
 * A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
 * Complete the function provided in the editor below.
 * It has one parameter: a pointer to a Node object named head that points to the head of a linked list.
 * Your function must return a boolean denoting whether or not there is a cycle in the list.
 * If there is a cycle, return true; otherwise, return false.
 * Note: If the list is empty, head will be null.
 *
 * Solution: Floyd's tortoise and the hare algorithm -  moves two pointers at different speeds through the sequence of values until they both point to equal values.
 */
public class Naive {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if(head == null || head.next == null)
            return false;
        Node slow = head.next;
        Node fast = head.next.next;
        while(fast != null) {
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
