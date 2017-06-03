package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 28/5/17.
 */
public class MaxSubtreeSum {

    private int max;
    private TreeNode<Integer> node;

    public static void main(String[] argv){
        MaxSubtreeSum maxSubtreeSum=new MaxSubtreeSum();
        TreeNode<Integer> root=new TreeNode<>(-1);
        root.left=new TreeNode<>(-2);
        root.right=new TreeNode<>(3);
        root.left.left=new TreeNode<>(5);
        root.left.right=new TreeNode<>(6);
        root.right.left=new TreeNode<>(-4);
        root.right.right=new TreeNode<>(5);
        maxSubtreeSum.find(root);
        System.out.print(maxSubtreeSum.node);
    }

    public MaxSubtreeSum(){
        max=Integer.MIN_VALUE;
    }

    /**
     * post order
     * get sum of parent and sum of left and right child
     * update max
     * O(n)
     * @param root
     * @return
     */
    public  int find(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int left=find(root.left);
        int right=find(root.right);
        int sum=left+right+root.val;
        if(sum>max){
            max=sum;
            node=root;
        }
        return sum;
    }
}
