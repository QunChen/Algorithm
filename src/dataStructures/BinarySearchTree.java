package dataStructures;

import dataStructures.BinaryTree.TreeNode;
import dataStructures.LinkedList.ListNode;

/**
 * Created by qun.chen on 2/5/17.
 */
public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree(){
        root=null;
    }

    /**
     * 1. set the root
     * 2. use two pointers, current and parent to go to lower level
     * 3. if less, go left, if greater, go right
     * 4. when the target is subtree is null, find the place
     * O(logn)
     * @param value
     */
    public void insert(int value){
        TreeNode<Integer> newTreeNode =new TreeNode<>(value);

        if(root==null){
            root= newTreeNode;
            return;
        }

        TreeNode<Integer> current=root;
        TreeNode<Integer> parent;
        while(true){
            parent=current;
            if(value<parent.val){
                current=current.left;
                if(current==null){
                    parent.left= newTreeNode;
                    return;
                }
            }else{
                current=current.right;
                if(current==null){
                    parent.right= newTreeNode;
                    return;
                }
            }
        }
    }

    /**
     * start from root,
     * go left when small, right when large, equal means find
     * O(logn)
     * @param value
     * @return
     */
    public TreeNode<Integer> find(int value){

        TreeNode<Integer> current=root;
        while(current!=null){
            if(current.val ==value){
                return current;
            }
            if(value<current.val){
                current=current.left;

            }else{
                current=current.right;
            }

        }
        return null;
    }

    /**
     * find it by not both larger or smaller than 2 values
     * O(logn)
     * @param value1
     * @param value2
     * @return
     */
    public TreeNode<Integer> findCommonParent(int value1, int value2){
        TreeNode<Integer> current=root;
        while(true){
            if(value1<current.val &&value2<current.val){
                current=current.left;
            }else if(value1>current.val &&value2>current.val){
                current=current.right;
            }else{
                return current;
            }
        }
    }

    /**
     * update the distance, similar to find
     * O(logn)
     * @param root
     * @param findValue
     * @return
     */
    public int getDistance(TreeNode<Integer> root, int findValue){
        int distance=0;
        TreeNode<Integer> current=root;
        while(true){
            if(findValue==current.val){
                return distance;
            }
            else if(findValue<current.val){
                current=current.left;
                distance++;
            }else{
                current=current.right;
                distance++;
            }
        }
    }

    /**
     * Created by qun.chen on 11/6/17.
     */
    public static class LinkedList {

        public static void main(String[] argv){
            LinkedList linkedList=new LinkedList();
            System.out.println(linkedList.add(1));
            System.out.println(linkedList.add(2));
            System.out.println(linkedList.add(3));
            System.out.println(linkedList.add(4));
            System.out.println(linkedList.remove(2));
            System.out.println(linkedList.get(2));
            System.out.println(linkedList.get(3));
            System.out.println(linkedList.set(2,5));
            linkedList.clear();
        }

        private int size ;
        private int modCount;
        private ListNode first;
        private ListNode last;

        public LinkedList(){

        }

        public boolean add(Integer e) {
            if(first==null){
                first=new ListNode(e);
                last=first;
            }else{
                last.next=new ListNode(e);
                last=last.next;
            }
            size++;
            modCount++;
            return true;
        }

        public boolean remove(int o) {
            ListNode prev=null;
            ListNode current=first;
            while(current!=null){
                if(current.val==o){
                    prev.next=current.next;
                    size--;
                    modCount++;
                    return true;
                }
                prev=current;
                current=current.next;
            }
            return false;
        }

        public void clear() {
            first=null;
            last=null;
            size=0;
            modCount++;
        }

        public Integer get(int index) {
            ListNode current=first;
            while(index>0&&current!=null){
                index--;
                current=current.next;
            }
            if(current==null){
                return -1;
            }else{
                return current.val;
            }
        }

        public Integer set(int index, Integer element) {
            ListNode current=first;
            while(index>0&&current!=null){
                index--;
                current=current.next;
            }
            if(current==null){
                return -1;
            }else{
                int old=current.val;
                current.val=element;
                return old;
            }
        }
    }
}
