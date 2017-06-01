package dataStructures;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 4/5/17.
 */
public class CheckBST {
    public static void main(String[] argv){

    }

    public static boolean isBST(TreeNode<Integer> root){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean isBST(TreeNode<Integer> root, int min, int max){
            if(root==null){
                return true;
            }

            if(root.val >max||root.val <min){
                return false;
            }else{
                return(
                isBST(root.left,min,root.val)&&
                isBST(root.right,root.val,max));
            }
    }


}
