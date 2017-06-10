package algorithm.list;

/**
 * Created by qun.chen on 9/6/17.
 */
public class LinkedListCycle {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != null && fast != null) {
            if (slow.val == fast.val) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }
}
