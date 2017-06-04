package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 4/5/17.
 */
public class ValidateBST {

     public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
     TreeNode(int x) { val = x; }
     }


    public boolean isValidBST(TreeNode root) {
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /**
     * base case: violate bst
     * recursively find a root that is violate the condition that smaller than right
     * and larger than left
     *
     * O(n)
     * @param root
     * @param min
     * @param max
     * @return
     */
    public  boolean isBST(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }

        if(root.val >=max||root.val <=min){
            return false;
        }else{
            return(
                    isBST(root.left,min,root.val)&&
                            isBST(root.right,root.val,max));
        }
    }


}
