package algorithm.list;

import dataStructures.BinaryTree.TreeNode;
import dataStructures.LinkedList.ListNode;

import java.util.PriorityQueue;

/**
 * Created by qun.chen on 8/6/17.
 */
public class MergeKSortedLists {

    public static void main(String[] argv){
        ListNode n1=new ListNode(1);
        n1.next=new ListNode(3);
        n1.next.next=new ListNode(5);

        ListNode n2=new ListNode(2);
        n2.next=new ListNode(4);
        n2.next.next=new ListNode(6);

        ListNode n3=new ListNode(7);
        n3.next=new ListNode(8);
        n3.next.next=new ListNode(9);

        ListNode[] lists={n1,n2,n3};

        MergeKSortedLists mergeKSortedLists=new MergeKSortedLists();
        mergeKSortedLists.mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> minheap=new PriorityQueue<>((l1, l2)->l1.val-l2.val);

        for(ListNode node:lists){
            if(node!=null){
                minheap.add(node);
            }
        }
        ListNode root=minheap.poll();
        if(root.next!=null){
            minheap.add(root.next);
        }
        ListNode parent=root;
        while(!minheap.isEmpty()){
            ListNode next=minheap.poll();
            parent.next=next;
            if(next.next!=null){
                minheap.add(next.next);
            }
            parent=next;
        }

        return root;
    }
}
