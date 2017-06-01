package algorithm.list;

import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 13/5/17.
 */
public class IntersectionOf2LinkedList {

    public static void main(String[] argv){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(-1);
        ListNode n7=new ListNode(-2);
        ListNode n8=new ListNode(-3);
        ListNode n9=new ListNode(3);
        ListNode n10=new ListNode(4);
        ListNode n11=new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        n9.next=n10;
        n10.next=n11;

        ListNode intersection=findIntersection(n1,n6);
        System.out.print(intersection);
    }

    public static ListNode findIntersection(ListNode listNode1, ListNode listNode2){
        int size1=getSize(listNode1);
        int size2=getSize(listNode2);

        if(size1>size2){
            int d=size1-size2;
            for(int i=0;i<d;i++){
                listNode1 = listNode1.next;
            }
        }else if(size2>size1){
            int d=size2-size1;
            for(int i=0;i<d;i++){
                listNode2 = listNode2.next;
            }
        }

        while(listNode1 !=null&& listNode2 !=null){
            if(listNode1.val== listNode2.val){
                return listNode1;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return  null;
    }

    public static int getSize(ListNode listNode){
        int size=0;
        while(listNode !=null){
            size++;
            listNode = listNode.next;
        }
        return  size;
    }
}
