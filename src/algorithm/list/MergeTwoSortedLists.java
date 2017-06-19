package algorithm.list;

import dataStructures.LinkedList.ListNode;
/**
 * Created by qun.chen on 9/6/17.
 */
public class MergeTwoSortedLists {

    public static void main(String[] argv){
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(1);
//        l2.next=new ListNode(2);
//        l2.next.next=new ListNode(4);

        MergeTwoSortedLists mergeTwoSortedLists=new MergeTwoSortedLists();
        mergeTwoSortedLists.mergeTwoLists(l1,l2);
    }

    /**
     * create dummy head and tail node
     * advance tail and one of the linked list node
     * append left over
     * O(l1 size+l2 size)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                if(dummy.next==null){
                    dummy.next=l1;
                }
                tail.next=l1;
                l1=l1.next;
            }else{
                if(dummy.next==null){
                    dummy.next=l2;
                }
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }

        while(l1!=null){
            if(dummy.next==null){
                dummy.next=l1;
            }
            tail.next=l1;
            tail=tail.next;
            l1=l1.next;
        }

        while(l2!=null){
            if(dummy.next==null){
                dummy.next=l2;
            }
            tail.next=l2;
            tail=tail.next;
            l2=l2.next;
        }


        return dummy.next;
    }
}
