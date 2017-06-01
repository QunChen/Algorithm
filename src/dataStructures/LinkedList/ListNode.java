package dataStructures.LinkedList;

/**
 * Created by qun.chen on 13/5/17.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
          val = x;
          next = null;
      }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
