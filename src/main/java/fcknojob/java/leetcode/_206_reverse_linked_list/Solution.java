package fcknojob.java.leetcode._206_reverse_linked_list;

import fcknojob.java.leetcode.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        return reverseList1(head);
    }

    // recursive solution
    public ListNode reverseList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList0(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    // non-recursive solution
    public ListNode reverseList1(ListNode head) {
        ListNode sentinal = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = sentinal.next;
            sentinal.next = head;
            head = next;
        }
        return sentinal.next;
    }
}
