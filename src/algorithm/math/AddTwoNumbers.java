package algorithm.math;

import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 10/6/17.
 */
public class AddTwoNumbers {
    /**
     * add the first node for 2 linked list and carry
     * set the value for new linked list and update the query if over 9
     * for the left ones, add the value with carry
     * if the carry is still there when no more nodes, create a new node as 1
     * O(l1.length+l2.length)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }

        if(l1!=null&&l2==null){
            return l1;
        }

        if(l1==null&&l2!=null){
            return l2;
        }
        ListNode head=new ListNode(0);
        ListNode result=head;
        int carry=0;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            result.next=new ListNode(sum%10);
            if(sum>=10){
                carry=1;
            }else{
                carry=0;
            }
            l1=l1.next;
            l2=l2.next;
            result=result.next;
        }

        while(l1!=null){
            int sum=l1.val+carry;
            result.next=new ListNode(sum%10);
            if(sum>=10){
                carry=1;
            }else{
                carry=0;
            }
            l1=l1.next;
            result=result.next;
        }

        while(l2!=null){
            int sum=l2.val+carry;
            result.next=new ListNode(sum%10);
            if(sum>=10){
                carry=1;
            }else{
                carry=0;
            }
            l2=l2.next;
            result=result.next;
        }

        if(carry==1){
            result.next=new ListNode(1);
        }

        return head.next;

    }
}
