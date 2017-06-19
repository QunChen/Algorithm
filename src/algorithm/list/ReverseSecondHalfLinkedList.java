package algorithm.list;

import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 30/5/17.
 */
public class ReverseSecondHalfLinkedList {

    public static void main(String[] argv){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;

        //ListNode head=reverseIteration(n1);
        reverse(n1);

        System.out.print(n1);
    }

    /**
     * use fast and slow to find middle, if the number is odd, move both 1 advance
     * store slow as connect to reversed list
     * make slow.next to null
     * then store pre, curr and next
     * make curr to pre
     * when next is null, reaching the last
     * make slow connect to last
     * O(n)
     * @param node
     */
    public static void reverse(ListNode node){
        if(node==null||node.next==null){
            return;
        }
        ListNode slow=node;
        ListNode fast=node.next;
        while(fast.next!=null){
            if(fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else{
                fast=fast.next;
                slow=slow.next;
            }
        }

        ListNode head=slow;

        ListNode prev=slow.next;
        ListNode curr=prev.next;
        ListNode next=curr.next;

        prev.next=null;

        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }


        head.next=prev;

    }
}
