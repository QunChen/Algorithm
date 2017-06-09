package dataStructures;

import dataStructures.BinaryTree.TreeNode;

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
}
