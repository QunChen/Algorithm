package dataStructures;

import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 11/6/17.
 */
public class Queue {

    public static void main(String[] argv){
        Queue queue=new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        queue.remove(3);
    }

    private int size ;
    private ListNode first;
    private ListNode last;

    public int peek(){
        return first.val;
    }

    public int poll(){
        if(first!=null){
            int val=first.val;
            first=first.next;
            return val;
        }
        return -1;

    }

    public boolean remove(int val){
        ListNode current=first;
        ListNode pre=null;
        while(current!=null){
            if(current.val==val){
                pre.next=current.next;
                return true;
            }
            pre=current;
            current=current.next;
        }
        return false;
    }

    public boolean offer(int val){
        if(first==null){
            first=new ListNode(val);
            last=first;
        }else{
            last.next=new ListNode(val);
            last=last.next;
        }
        return true;
    }
}
