package algorithm.list;

/**
 * Created by qun.chen on 27/5/17.
 */
public class SwapNodesInPairs {


     // Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    /**
     * a. if only 1 node, return
     * b. if has 2 nodes, reverse 2 nodes and return
     * 1. set pre, current, next and next2
     * 2. when next is not null, pre to next, next to current, current to next 2
     * 3. advance all
     * O(n)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }

        if(head.next==null){
            return head;
        }

        if(head.next.next==null){
            ListNode temp=head;//1
            head = head.next;//2
            head.next=temp;//1
            temp.next=null;
            return head;
        }

        ListNode pre=null; //null - 1
        ListNode cur=head;  //1 - 3
        ListNode next=head.next; //2 - 4
        ListNode next2=head.next.next;//3 - null
        head=next;//2

        while(next!=null){
            if(pre!=null){
                pre.next=next; //null->2  / 1 -> 4
            }
            next.next=cur; //2->1 /  4->3
            cur.next=next2; //1->3 / 3->null

            pre=cur; //1 / 3
            cur=next2;//3 / null
            if(next2!=null){
                next=next2.next;//4 / null
                if(next2.next!=null){
                    next2=next2.next.next;//null
                }else{
                    next2=null;//null
                }
            }else{
                break;
            }

        }

        return head;
    }
}
