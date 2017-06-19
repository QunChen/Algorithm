package algorithm.list;

import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 9/6/17.
 */
public class PalindromeLinkedList {

    public static void main(String[] argv){
        PalindromeLinkedList palindromeLinkedList=new PalindromeLinkedList();


        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(3);
        root.next.next.next.next.next=new ListNode(2);
        root.next.next.next.next.next.next=new ListNode(1);
        System.out.println(palindromeLinkedList.isPalindrome(root));
    }

    /**
     * use slow and fast pointer to find the middle element
     * reverse the later half, if the size is odd, advance slow pointer
     * then compare early half and later half
     * O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        boolean isOdd=true;
        while(fast!=null){
            if(fast.next==null){
                isOdd=false;
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode next=slow.next;
        if(isOdd){
            reverse(null,head,slow);
            return isSame(slow.next,next);
        }else{
            reverse(null,head,slow);
            return isSame(slow,next);
        }
    }

    /**
     * when reach upbound,reverse next pointer
     * recursively to next node, keep pre and current
     * for stack call, when return, reverse next pointer
     * O(n)
     * @param prev
     * @param node
     * @param upbound
     */
    private void reverse(ListNode prev,ListNode node,ListNode upbound){
        if(node.val==upbound.val){
            node.next=prev;
            return;
        }
        reverse(node,node.next,upbound);
        node.next=prev;
    }

    /**
     * compare each node and advance
     * if any node has next, is not same
     * O(n)
     * @param node1
     * @param node2
     * @return
     */
    private boolean isSame(ListNode node1,ListNode node2){
        if(node1==null||node2==null){
            return false;
        }

        while(node1!=null&&node2!=null){
            if(node1.val!=node2.val){
                return false;
            }
            node1=node1.next;
            node2=node2.next;
        }

        if(!(node1==null&&node2==null)){
            return false;
        }
        return true;
    }
}
