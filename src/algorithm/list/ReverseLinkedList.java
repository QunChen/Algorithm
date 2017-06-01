package algorithm.list;

import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 13/5/17.
 */
public class ReverseLinkedList {

    public static void main(String[] argv){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        //ListNode head=reverseIteration(n1);
        ListNode head=reverseRecursion(n1);
        System.out.print(head);
    }
    public static ListNode reverseRecursion(ListNode head){
        if(head==null){
            return head;
        }

        return reverseRecursion(head,null);
    }

    public static ListNode reverseRecursion(ListNode current,ListNode prev){

        if(current.next==null){
            current.next=prev;
            return current;
        }

        ListNode head=reverseRecursion(current.next,current);
        current.next=prev;
        return head;
    }

    public ListNode reverseRecursion2(ListNode node,ListNode parent) {
        ListNode next=node.next;
        node.next=parent;

        if(next==null){
            return node;
        }


        return reverseRecursion(next,node);
    }

    public static ListNode reverseIteration(ListNode head){
            if(head==null){
                return null;
            }

            ListNode next=head.next;
            boolean isFirst=true;
            while(next!=null){
                ListNode temp=next.next;
                next.next=head;
                if(isFirst){
                    head.next=null;
                    isFirst=false;
                }
                head=next;
                next=temp;

            }


            return head;
    }
}
