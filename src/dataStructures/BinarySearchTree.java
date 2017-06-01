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
