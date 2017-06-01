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
    }

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

        ListNode current=slow;
        ListNode next=slow.next;
        ListNode next2=null;
        if(next!=null){
            next2=next.next;
        }

        current.next =null;

        while(next!=null){
            next.next=current;
            current=next;
            next=next2;
            if(next!=null){
                next2=next.next;
            }else{
                break;
            }

        }
    }
}
