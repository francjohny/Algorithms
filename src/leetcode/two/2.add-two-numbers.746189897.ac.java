package leetcode.two;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0, i = 0;
        ListNode result = new ListNode(), output = result;
        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            result.next = new ListNode(sum);
            result = result.next;
        }
        while (l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            result.next = new ListNode(sum);
            result = result.next;
        }
        while (l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            result.next = new ListNode(sum);
            result = result.next;
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
            result = result.next;
        }
        return output.next;
    }
}
