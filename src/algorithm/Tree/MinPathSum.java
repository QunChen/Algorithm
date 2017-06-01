package algorithm.Tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 30/5/17.
 */
public class MinPathSum {


    public static void main(String[] argv){
        MinPathSum minPathSum=new MinPathSum();
        TreeNode<Integer> root=new TreeNode<>(-1);
        root.left=new TreeNode<>(-2);
        root.right=new TreeNode<>(3);
        root.left.left=new TreeNode<>(5);
        root.left.right=new TreeNode<>(6);
        root.right.left=new TreeNode<>(-4);
        root.right.right=new TreeNode<>(5);
        System.out.print(minPathSum.find(root));
    }


    public  int find(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int left=find(root.left);
        int right=find(root.right);
        return Math.min(left,right)+root.val;
    }
}
